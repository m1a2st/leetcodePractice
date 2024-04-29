package thread.basic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    @Test
    public void test() {
        Thread t1 = new ChangeObjectThread("t1");
        Thread t2 = new ChangeObjectThread("t2");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() +" 即將進入無限阻塞");
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " 被中斷");
            } else {
                System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
        }
    }
}
