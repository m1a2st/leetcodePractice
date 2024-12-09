package main.java.parctice.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateDemo3 {

    public static final int MAX_TURNS = 3;
    public static final int COMPUTE_TIMES = 100_000_000;

    // create a class for Callable interface
    static class ReturnableTask implements Callable<Long> {

        // asynchronous task
        @Override
        public Long call() throws InterruptedException {
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

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ReturnableTask task = new ReturnableTask();
        FutureTask<Long> longFutureTask = new FutureTask<>(task);
        Thread thread = new Thread(longFutureTask, "ReturnableTaskThread");
        thread.start();
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Do something else");
        for (int i = 0; i < COMPUTE_TIMES; i++) {
            int j = i * i;
        }
        System.out.println(Thread.currentThread().getName() + " get result:");
        System.out.println("ReturnableTaskThread takes " + longFutureTask.get() + " ms");
        System.out.println(Thread.currentThread().getName() + " is done");
    }
}
