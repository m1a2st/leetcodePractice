package parctice.thread.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SpinLock implements Lock {

    /**
     * 當前鎖的擁有者
     * 使用 Thread 作為同步狀態
     */
    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private final int count = 0;

    @Override
    public void lock() {
        Thread currentThread = Thread.currentThread();
        // 自旋 CAS
        while (!owner.compareAndSet(null, currentThread)) {
            // Do nothing
            // 讓出當前剩餘的 CPU 時間片
            Thread.yield();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        // 只有擁有鎖的線程才能解鎖
        if (currentThread == owner.get()) {
            // 設置有擁有者為空，這裡不需要 compareAndSet，
            // 因為只有擁有鎖的線程才能解鎖
            owner.set(null);
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
