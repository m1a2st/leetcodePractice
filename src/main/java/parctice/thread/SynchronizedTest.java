package main.java.parctice.thread;

import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class SynchronizedTest implements Runnable {

    private final List<String> list;

    public SynchronizedTest(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                synchronized (list) {
                    list.add("a" + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TestSynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new java.util.ArrayList<>();
        Thread thread1 = new Thread(new SynchronizedTest(list));
        Thread thread2 = new Thread(new SynchronizedTest(list));
        Thread thread3 = new Thread(new SynchronizedTest(list));
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(list.size());
    }
}
