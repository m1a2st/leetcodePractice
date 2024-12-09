package parctice.se.ex2.module21_26;

public class DeadLock {
    public static void main(String[] args) {
        T1 t1 = new T1(3, "T1"); // 3 secs
        T2 t2 = new T2(0, "T2"); // 0 secs

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);  // 1 secs
        } catch (Exception e) {
        }
        t1.stop();
    }
}

class T1 extends Thread {
    private int sleepTime = 0;
    public static boolean finished = false;

    public T1(int second, String name) {
        super(name);
        sleepTime = second;
    }

    public void run() {
        System.out.println("T1 running...");
        try {
            Thread.sleep(sleepTime * 1000L); // 3 secs
        } catch (Exception e) {
        }
        System.out.println("T1 finished.");
        T1.finished = true;
    }
}

class T2 extends Thread {
    private int sleepTime = 0;

    public T2(int second, String name) {
        super(name);
        sleepTime = second;
    }

    public void run() {
        while (!T1.finished) {
            Thread.yield();
        }
        System.out.println("T2 running...");
        System.out.println("T2 finished.");
    }
}
