package thread.basic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    @Test
    public void testReentrantLock() {
        final int TURNS = 1000;
        final int THREADS = 10;
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);
        ReentrantLock lock = new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(THREADS);
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            pool.submit(() -> {
                try {
                    for (int j = 0; j < TURNS; j++) {
                        IncrementData.lockAndIncrease(lock);
                    }
                    System.out.println("本线程累加完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 线程执行完成，倒数闩减少一次
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + IncrementData.sum);
        System.out.println("time=" + (end - start) / 1000F);
    }
}
