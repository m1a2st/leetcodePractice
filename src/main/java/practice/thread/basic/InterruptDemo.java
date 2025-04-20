package practice.thread.basic;

public class InterruptDemo {

    public static final int SLEEP_GAP = 5000;
    public static final int MAX_TURN = 50;

    static class SleepThread extends Thread {
        static int threadSeqNumber = 1;

        public SleepThread() {
            super("SleepThread-" + threadSeqNumber++);
        }

        @Override
        public void run() {
            System.out.println(getName() + " is going tp sleep");
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(getName() + " is interrupted");
                return;
            }
            System.out.println(getName() + " is done");
        }
    }

    public static void main(String[] args) {
        SleepThread thread1 = new SleepThread();
        thread1.start();
        SleepThread thread2 = new SleepThread();
        thread2.start();
        ThreadUtil.sleepMilliSeconds(2);
        thread1.interrupt();
        ThreadUtil.sleepMilliSeconds(10000);
        thread2.interrupt();
        ThreadUtil.sleepMilliSeconds(2);
        System.out.println(Thread.currentThread().getName() + " is done");
    }
}
