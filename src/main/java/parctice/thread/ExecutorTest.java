package parctice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author m1a2st
 * @Date 2023/8/15
 * @Version v1.0
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
