package practice.thread.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            LockSupport.parkNanos(TimeUnit.MICROSECONDS.toNanos(60));
            boolean success = future.complete("hello");
            if (success) {
                System.out.println("hello 设置成功");
            } else {
                System.out.println("hello 设置失败");
            }
        }).start();

        new Thread(() -> {
            boolean success = future.complete("world");
            if (success) {
                System.out.println("world 设置成功");
            } else {
                System.out.println("world 设置失败");
            }
        }).start();

        String result = future.get();
        System.out.println(result + " 我一定是成功的那个");
    }
}
