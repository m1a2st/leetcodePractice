package thread.basic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class PlusTest {

    final int MAX_TREAD = 10;
    final int MAX_TURN = 1000;

    @Test
    public void testNotSafePlus() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(MAX_TREAD);
        NotSafePlus counter = new NotSafePlus();
        Runnable runnable = () -> {
            for (int i = 0; i < MAX_TURN; i++) {
                counter.selfPlus();
            }
            latch.countDown();
        };
        for (int i = 0; i < MAX_TREAD; i++) {
            new Thread(runnable).start();
        }
        latch.await();
        Thread.sleep(1000);
        System.out.println("理論结果：" + MAX_TURN * MAX_TREAD);
        System.out.println("實際结果：" + counter.getAmount());
        System.out.println("差距是：" + (MAX_TURN * MAX_TREAD - counter.getAmount()));
    }


    public class NotSafePlus {
        private int amount = 0;

        public synchronized void selfPlus() {
            amount++;
        }

        public int getAmount() {
            return amount;
        }
    }
}
