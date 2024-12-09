package parctice.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/12
 * @Version v1.0
 */
public class ArrayListThreadTest implements Runnable {

    private final List<String> list;

    public ArrayListThreadTest(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                list.add("a" + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TestArrayListThreadTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Thread thread1 = new Thread(new ArrayListThreadTest(list));
        Thread thread2 = new Thread(new ArrayListThreadTest(list));
        Thread thread3 = new Thread(new ArrayListThreadTest(list));
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(list.size());
    }
}
