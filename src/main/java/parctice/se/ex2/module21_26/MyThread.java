package main.java.parctice.se.ex2.module21_26;

public class MyThread extends Thread {
    public static boolean ready = false; //「開跑」變數

    //以四種不同的建構者函數來建立物件 (function overloading)
    public MyThread() {
        super("NT1");
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    public MyThread(String name, int priority, boolean isDaemon) {
        super(name);
        setPriority(priority);
        setDaemon(isDaemon);
    }

    public void run() {
        while (!ready) {
        } // 只要沒開跑，就不執行下一行。

        System.out.println(
                "My name is " + getName()
                        + "..... My priority is " + getPriority()
                        + "..... Am I alive? " + isAlive()
                        + "..... Am I daemon? " + isDaemon()
        );


//      String nameOfcurrentThread = Thread.currentThread().getName();
//      System.out.println("目前正在執行的執行緒的名字="+nameOfcurrentThread);
    }
}
