package parctice.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("a");
        queue.offer("b");
//        queue.poll();
        queue.offer("c");
        queue.forEach(System.out::println);
        System.out.println("=====");
        queue.poll();
        queue.forEach(System.out::println);
    }
}
