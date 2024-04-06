package thread.basic;

public class CreateDemo {

    public static final int MAX_TURNS = 5;

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    static int threadNo = 1;

    static class DemoThread extends Thread {
        public DemoThread() {
            super("DemoThread - " + threadNo++);
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_TURNS; i++) {
                System.out.println(getName() + " is running " + i + " times");
            }
            System.out.println(getName() + " is done");
        }
    }

    public static void main(String[] args) {
        Thread thread;
        for (int i = 0; i < 3; i++) {
            thread = new DemoThread();
            thread.start();
        }
        System.out.println(getCurrentThreadName() + " is done");
    }

}
