package practice.thread.basic;

import java.util.ArrayList;

public class StatusDemo {

    public static final long MAX_TURNS = 5;
    static int threadSeqNo = 0;
    static ArrayList<Thread> threads = new ArrayList<>();

    private static void printThreadStatus() {
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " is " + thread.getState());
        }
    }

    private static void addStatusThread(Thread thread) {
        threads.add(thread);
    }

    static class DemoThread extends Thread {
        public DemoThread() {
            super("DemoThread - " + ++threadSeqNo);
            addStatusThread(this);
        }

        @Override
        public void run() {
            System.out.println(getName() + " status is " + getState());
            for (int i = 0; i < MAX_TURNS; i++) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                printThreadStatus();
            }
            System.out.println(getName() + " is done");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        addStatusThread(Thread.currentThread());
        DemoThread demoThread1 = new DemoThread();
        System.out.println(demoThread1.getName() + " status is " + demoThread1.getState());
        DemoThread demoThread2 = new DemoThread();
        System.out.println(demoThread2.getName() + " status is " + demoThread2.getState());
        DemoThread demoThread3 = new DemoThread();
        System.out.println(demoThread3.getName() + " status is " + demoThread3.getState());
        demoThread1.start();
        Thread.sleep(1000);
        demoThread2.start();
        Thread.sleep(1000);
        demoThread3.start();
        Thread.sleep(1000);
    }
}
