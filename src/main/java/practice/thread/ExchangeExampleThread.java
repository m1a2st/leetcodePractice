package practice.thread;

import java.util.concurrent.Exchanger;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class ExchangeExampleThread implements Runnable {

    private final Exchanger<String> exchanger;
    private final String threadName;
    private String message;

    public ExchangeExampleThread(Exchanger<String> exchanger, String threadName, String message) {
        this.exchanger = exchanger;
        this.threadName = threadName;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " message: " + message);
            message = exchanger.exchange(message);
            System.out.println(threadName + " message: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExchangeExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new ExchangeExampleThread(exchanger, "thread1", "message1")).start();
//        new Thread(new ExchangeExampleThread(exchanger, "thread2", "message2")).start();
    }
}
