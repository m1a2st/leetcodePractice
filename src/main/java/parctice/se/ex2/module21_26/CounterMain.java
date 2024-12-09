package main.java.parctice.se.ex2.module21_26;
//單執行緒

public class CounterMain {
    int counter = 10;

    public CounterMain() {
    } // 建構者函數

    public void runMethod() { // 一般的成員方法
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
        CounterMain m1 = new CounterMain();
        CounterMain m2 = new CounterMain();
        m1.runMethod();
        m2.runMethod();
    }

}
