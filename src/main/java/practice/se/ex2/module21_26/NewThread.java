package practice.se.ex2.module21_26;

public class NewThread implements Runnable {
    String name; // 執行緒名字
    Thread t;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name); // 建構元內即同時建構執行緒
        System.out.println("New thread: " + t); // 並印出該執行緒相關資料
        t.start(); // 啟動執行緒
    }

    public void run() {
        try {
            for (int i = 2; i > 0; i--) {
                System.out.println(name + ": " + i); // 印出目前正在 run()內run 的執行緒的名字和i值
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " 結束exiting !");
    }
}
