package main.java.parctice.thread;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author m1a2st
 * @Date 2023/8/15
 * @Version v1.0
 */
public class Channel {
    private final Queue<String> queue = new LinkedList<>();

    public synchronized void put(String message) {
        while (queue.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(message);
        notifyAll();
    }

    public synchronized String take() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        return queue.poll();
    }
}

class Producer implements Runnable {
    private final Channel channel;
    private static int id = 0;

    public Producer(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String message = "producer" + nextId();
            System.out.println(message);
            channel.put(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized int nextId() {
        return id++;
    }
}

class Consumer implements Runnable {
    private final Channel channel;

    public Consumer(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        System.out.println(channel.take());
    }
}

class TestChannel {

    @Test
    public void test() {
        Channel channel = new Channel();
        Thread producer = new Thread(new Producer(channel));
        Thread produce1 = new Thread(new Producer(channel));
        Thread consume = new Thread(new Consumer(channel));

        producer.start();
        produce1.start();
        consume.start();
        System.out.println(channel.take());
    }
}
