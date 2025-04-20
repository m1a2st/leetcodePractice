package practice.thread.basic;

public class CreateDemo2 {

    public static final int MAX_TURNS = 5;

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    static int threadNo = 1;

    static class RunnableTarget implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_TURNS; i++) {
                System.out.println(getCurrentThreadName() + " is running " + i + " times");
            }
            System.out.println(getCurrentThreadName() + " is done");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new RunnableTarget(), "RunnableTarget - " + threadNo++);
            thread.start();
        }
        System.out.println(getCurrentThreadName() + " is done");
    }
}
