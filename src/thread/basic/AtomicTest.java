package thread.basic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

public class AtomicTest {

    @Test
    public void testAtomicStampedReference() {
        CountDownLatch latch = new CountDownLatch(2);
        AtomicStampedReference<Integer> reference =
                new AtomicStampedReference<>(1, 0);
        ThreadPool.MixedTargetThreadTargetLazyHolder.getInnerExecutor()
                .submit(() -> {
                    boolean success = false;
                    int stamp = reference.getStamp();
                    success = reference.compareAndSet(1, 2, stamp, stamp + 1);
                    stamp++;
                    latch.countDown();
                });
        LongAdder adder = new LongAdder();
    }
}
