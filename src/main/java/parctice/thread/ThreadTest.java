package main.java.parctice.thread;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class ThreadTest extends Thread {

    private final String msg;

    public ThreadTest(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(msg);
    }
}

class TestThread {

    @Test
    public void test() {
        ThreadTest threadTest1 = new ThreadTest("Hello World! 1");
        ThreadTest threadTest2 = new ThreadTest("Hello World! 2");
        ThreadTest threadTest3 = new ThreadTest("Hello World! 3");
        ThreadTest threadTest4 = new ThreadTest("Hello World! 4");
        ThreadTest threadTest5 = new ThreadTest("Hello World! 5");
        ThreadTest threadTest6 = new ThreadTest("Hello World! 6");
        ThreadTest threadTest8 = new ThreadTest("Hello World! 8");
        ThreadTest threadTest7 = new ThreadTest("Hello World! 7");
        ThreadTest threadTest9 = new ThreadTest("Hello World! 9");
        threadTest1.start();
        threadTest2.start();
        threadTest5.start();
        threadTest3.start();
        threadTest4.start();
        threadTest7.start();
        threadTest6.start();
        threadTest9.start();
        threadTest8.start();
    }
}
