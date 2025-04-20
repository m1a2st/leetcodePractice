package practice.thread.basic;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());
        System.out.println(Thread.currentThread().getName() + "運行結束");
        thread.start();
    }

    private static void anotherFun() {
        int a = 1, b = 2;
        int c = a / b;
        anotherFun2();
    }

    private static void anotherFun2() {
        int a = 1, b = 2;
        int c = a / b;
    }
}
