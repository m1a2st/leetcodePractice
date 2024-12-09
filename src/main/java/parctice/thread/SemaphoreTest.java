package main.java.parctice.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class SemaphoreTest implements Runnable {

    private final String name;
    private final Semaphore semaphore;

    public SemaphoreTest(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(name + " 開始執行");
            System.out.println(name + " 執行完畢");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TestSemaphore {

    @Test
    public void test() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        Thread thread1 = new Thread(new SemaphoreTest("thread1", semaphore));
        Thread thread2 = new Thread(new SemaphoreTest("thread2", semaphore));
        Thread thread3 = new Thread(new SemaphoreTest("thread3", semaphore));
        Thread thread4 = new Thread(new SemaphoreTest("thread4", semaphore));
        Thread thread5 = new Thread(new SemaphoreTest("thread5", semaphore));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
    }
}
