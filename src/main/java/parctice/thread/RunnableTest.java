package main.java.parctice.thread;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class RunnableTest implements Runnable {

    private final String msg;

    public RunnableTest(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Hello World!" + msg);
    }
}

class TestRunnable {

    public static void main(String[] args) {
        RunnableTest runnableTest1 = new RunnableTest("1");
        RunnableTest runnableTest2 = new RunnableTest("2");
        RunnableTest runnableTest3 = new RunnableTest("3");
        RunnableTest runnableTest4 = new RunnableTest("4");
        RunnableTest runnableTest5 = new RunnableTest("5");
        RunnableTest runnableTest6 = new RunnableTest("6");
        RunnableTest runnableTest7 = new RunnableTest("7");
        RunnableTest runnableTest8 = new RunnableTest("8");
        RunnableTest runnableTest9 = new RunnableTest("9");
        new Thread(runnableTest1).start();
        new Thread(runnableTest2).start();
        new Thread(runnableTest3).start();
        new Thread(runnableTest4).start();
        new Thread(runnableTest5).start();
        new Thread(runnableTest6).start();
        new Thread(runnableTest7).start();
        new Thread(runnableTest8).start();
        new Thread(runnableTest9).start();
    }
}
