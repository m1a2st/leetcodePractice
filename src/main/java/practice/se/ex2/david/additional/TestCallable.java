package practice.se.ex2.david.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = 1; i <= 1000000000; i++) {
            sum += i;
        }
        return sum;
    }
}

public class TestCallable {
    public static void main(String[] args) {
        // JVM可使用的CPU核心數
        int coreNum = Runtime.getRuntime().availableProcessors();
        // 在thread pool內建立固定量的執行緒並重複利用它們來進行運算
        ExecutorService executor = Executors.newFixedThreadPool(coreNum);
        List<Future<Long>> futures = new ArrayList<Future<Long>>();
        for (int i = 0; i < 10; i++) {
            Callable<Long> callable = new MyCallable();
            // submit()會執行一個有回傳值的工作(task，runnable則不會回傳)
            Future<Long> future = executor.submit(callable);
            futures.add(future);
        }
        long sum = 0;
        System.out.println(futures.size());
        // 取得結果
        for (Future<Long> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        // 要求ExecutorService準備停止，已經執行的任務會等待其結束，而且不再接受新任務
        executor.shutdown();
        try {
            // 依據指定時間(60秒)等待執行的任務結束。
            // 回傳true代表ExecutorService已經終止；false代表已經過了指定時間，但ExecutorService尚未終止
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // 強制cancel目前正在執行的任務
                executor.shutdownNow();
                // 依據指定時間(60秒)等待執行的任務一一被cancel
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("ExecutorService did not terminate!!");
                }
            } else {
                System.out.println("ExecutorService terminated!!");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executor.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
