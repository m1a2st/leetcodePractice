package parctice.se.ex2.module21_26;

public class NoDeadLock {
    public static void main(String[] args) {
        T1_1 t1 = new T1_1(3, "T1_1"); // 3 secs
        T2_1 t2 = new T2_1(0, "T2_1"); // 0 secs

        t1.start();
        t2.start();
        try {
            Thread.sleep(5000); // 原1 sec 比 3 secs 小 , 使得t1仍在sleep時被 stop
        } catch (Exception e) {
        }                       // 因此無法執行T1_1.finished = true;
        t1.stop();              // 造成t2之迴圈 while(!T1_1.finished){yield();} 為真,無法離開
    }
}

class T1_1 extends Thread {
    private int sleepTime = 0;
    public static boolean finished = false;

    public T1_1(int second, String name) {
        super(name);
        sleepTime = second;
    }

    public void run() {
        System.out.println("T1_1 running...");
        try {
            Thread.sleep(sleepTime * 1000L); // 3 secs
        } catch (Exception e) {
        }
        System.out.println("T1_1 finished.");
        T1_1.finished = true;
    }
}

class T2_1 extends Thread {
    private int sleepTime = 0;

    public T2_1(int second, String name) {
        super(name);
        sleepTime = second;
    }

    public void run() {
        while (!T1_1.finished) {
            Thread.yield();
        }
        System.out.println("T2_1 running...");
        System.out.println("T2_1 finished.");
    }
}
