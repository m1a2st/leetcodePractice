package practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author m1a2st
 * @Date 2023/8/13
 * @Version v1.0
 */
public class LockTest implements Runnable {

    private final Lock lock;
    private final List<String> list;

    public LockTest(Lock lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                list.add("a" + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

class LockTestMain {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        List<String> list = new ArrayList<>();
        Thread thread1 = new Thread(new LockTest(lock, list));
        Thread thread2 = new Thread(new LockTest(lock, list));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        list.forEach(System.out::println);
    }
}
