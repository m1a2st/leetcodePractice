package main.java.parctice.thread;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class SumThread implements Runnable {

    int sum = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            notify();
        }
    }
}

class TestSumThread {

    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread = new SumThread();
        Thread thread = new Thread(sumThread);
        thread.start();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println(sumThread.sum);
    }
}
