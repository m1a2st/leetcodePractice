package thread.basic;

import java.util.concurrent.*;

public class CreateDemo4 {

    public static final int MAX_TURNS = 5;
    public static final int COMPUTE_TIMES = 100_000_000;

    private static final ExecutorService pool = Executors.newFixedThreadPool(3);

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    static class DemoThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            for (int i = 0; i < MAX_TURNS; i++) {
                System.out.println(Thread.currentThread().getName() + " is running " + i + " times");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " is done");
        }
    }

    static class ReturnableTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.sleep(1000);
            for (int i = 0; i < COMPUTE_TIMES; i++) {
                int j = i * i;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " is done");
            return endTime - startTime;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        pool.execute(new DemoThread());
        pool.execute(() -> {
            for (int i = 0; i < MAX_TURNS; i++) {
                System.out.println(Thread.currentThread().getName() + " is running " + i + " times");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Future<Long> future = pool.submit(new ReturnableTask());
        Long res = future.get();
        System.out.println(Thread.currentThread().getName() + " get result:" + res);

    }
}
