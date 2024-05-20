package se.ex2.module21_26;

public class CounterThread extends Thread {
    int counter = 10;

    public CounterThread() {
    } // 建構者函數

    public void run() { // 執行緒執行的地方
        while (counter > 0) {
            System.out.println(counter);
            counter--;

            try {
                Thread.sleep(1000); // 暫停一秒
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] arg) {
        CounterThread t1 = new CounterThread(); // 產生執行緒物件
        CounterThread t2 = new CounterThread();
        t1.start(); // 呼叫執行緒物件的start()方法(即啟動執行緒) , 隨即執行物件中的run方法
        t2.start();
//		t1.run();
//		t2.run();
    }
}
