package parctice.thread.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleMockLock implements Lock {

    private final Sync sync = new Sync();

    // 自定義的內部類：同步器
    // AbstractQueuedSynchronizer.state 表示鎖的狀態
    // AbstractQueuedSynchronizer.state = 1 表示 鎖沒有被占用
    // AbstractQueuedSynchronizer.state = 0 表示 鎖沒已經被占用
    private static class Sync extends AbstractQueuedSynchronizer {

        protected boolean tryAcquire(int arg) {
            // CAS更新狀態為1
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int arg) {
            // 如果當前線程不是占用鎖的線程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            // 如果鎖的狀態為沒有占用
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            // 不需要使用CAS操作，因為下面的操作不存在並發場景
            setExclusiveOwnerThread(null);
            // 設置狀態
            setState(0);
            return true;
        }
    }

    // 顯示鎖的搶佔方法
    @Override
    public void lock() {
        // 委託給同步器
        sync.acquire(1);
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
        // 委託給同步器
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
