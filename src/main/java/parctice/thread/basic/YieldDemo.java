package main.java.parctice.thread.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class YieldDemo {

    public static final int MAX_TURN = 1000000;
    public static AtomicInteger index = new AtomicInteger(0);
    public static Map<String, AtomicInteger> metric = new HashMap<>();

    public static void printMetric() {
        for (Map.Entry<String, AtomicInteger> entry : metric.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().get());
        }
    }

    static class YieldThread extends Thread {

        static int threadSeqNumber = 1;

        public YieldThread() {
            super("YieldThread-" + threadSeqNumber++);
            metric.put(this.getName(), new AtomicInteger(0));
        }

        @Override
        public void run() {
            for (int i = 1; i < MAX_TURN && index.get() < MAX_TURN; i++) {
                System.out.println("Thread priority: " + getPriority() + " " + getName());
                index.incrementAndGet();
                metric.get(this.getName()).incrementAndGet();
                if (i % 2 == 0) {
                    Thread.yield();
                }
            }
            printMetric();
            System.out.println(getName() + " end");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new YieldThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        Thread thread2 = new YieldThread();
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}
