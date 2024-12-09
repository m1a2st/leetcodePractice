package parctice.thread.basic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

import static parctice.thread.basic.TestCompareAndSwap.OptimisticLockingPlus.THREAD_COUNT;

public class TestCompareAndSwap {

    static class OptimisticLockingPlus {
        public static final int THREAD_COUNT = 10;

        private volatile int value;

        private static final Unsafe unsafe = getUnsafe();

        private static final long valueOffset;

        private static final AtomicLong failure = new AtomicLong(0);

        static {
            try {
                // 取得 value 屬性的記憶體偏移
                valueOffset = unsafe.objectFieldOffset(
                        OptimisticLockingPlus.class.getDeclaredField("value"));
                System.out.println("valueOffset: " + valueOffset);
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public static Unsafe getUnsafe() {
            try {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }

        // 通過 CAS 原子操作，進行「比較並交換」
        public final boolean unSafeCompareAndSwap(int oldValue, int newValue) {
            // 原子操作，使用 unsafe.compareAndSwapInt() 方法 進行 value 屬性的交換
            return unsafe.compareAndSwapInt(this, valueOffset, oldValue, newValue);
        }

        // 使用無鎖編程實現安全的自增方法
        public void selfPlus() {
            int oldValue = value;
            int i = 0;
            // 通過 CAS 原子操作，如果操作失敗就自旋，直到成功
            do {
                // 獲取當前值
                oldValue = value;
                if (i++ > 1) {
                    failure.incrementAndGet();
                }
            } while (!unSafeCompareAndSwap(oldValue, oldValue + 1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OptimisticLockingPlus cas = new OptimisticLockingPlus();
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            ThreadPoolExecutor executor = ThreadPool.MixedTargetThreadTargetLazyHolder.getInnerExecutor();
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    cas.selfPlus();
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("實際結果：" + cas.value);
        System.out.println("失敗次數：" + OptimisticLockingPlus.failure.get());
    }
}
