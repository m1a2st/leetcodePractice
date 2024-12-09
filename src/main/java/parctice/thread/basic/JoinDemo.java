package parctice.thread.basic;

public class JoinDemo {

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
        System.out.println("Starting " + thread1.getName());
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SleepThread thread2 = new SleepThread();
        System.out.println("Starting " + thread2.getName());
        thread2.start();
        try {
            thread2.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " is done");
    }
}
