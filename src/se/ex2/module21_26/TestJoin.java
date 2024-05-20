package se.ex2.module21_26;

public class TestJoin {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        NewThread nt1 = new NewThread("NT1");
        NewThread nt2 = new NewThread("NT2");
        NewThread nt3 = new NewThread("NT3");
        System.out.println();

        System.out.println("開始 Thread NT1 is alive: " + nt1.t.isAlive());
        System.out.println("開始 Thread NT2 is alive: " + nt2.t.isAlive());
        System.out.println("開始 Thread NT3 is alive: " + nt3.t.isAlive());

        // 等以上執行緒結束

        try {
            System.out.println(" [主執行緒: " + name + "]開始等候以上執行緒結束.....");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("後來 Thread NT1 is alive: " + nt1.t.isAlive());
        System.out.println("後來 Thread NT2 is alive: " + nt2.t.isAlive());
        System.out.println("後來 Thread NT3 is alive: " + nt3.t.isAlive());

        // 等以上執行緒結束後,最後才執行此段程式碼
        System.out.println(" 最後" + " [主執行緒: " + name + "]結束exiting !");
    }
}
