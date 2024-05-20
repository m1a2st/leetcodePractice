package thread.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCommunicationTest {

    // 創建一個顯式鎖
    static Lock lock = new ReentrantLock();
    // 獲取一個綁定顯式鎖的 Condition 對象
    private static final Condition condition = lock.newCondition();

    // 等待執行緒異步的目標任務
    static class WaitTarget implements Runnable {
        @Override
        public void run() {
            // 搶鎖
            lock.lock();
            try {
                System.out.println("WaitTarget 等待通知");
                // 開始等待，並且釋放鎖
                condition.await();
                System.out.println("WaitTarget 收到通知");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 釋放鎖
                lock.unlock();
            }
        }
    }

    // 通知執行緒的異步目標任務
    static class NotifyTarget implements Runnable {
        @Override
        public void run() {
            // 搶鎖
            lock.lock();
            try {
                System.out.println("NotifyTarget 發送通知");
                // 發送通知
                condition.signal();
                System.out.println("NotifyTarget 發送通知完成");
            } finally {
                // 釋放鎖
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 創建一個執行緒池
        Thread waitThread = new Thread(new WaitTarget(), "WaitTarget");
        Thread notifyThread = new Thread(new NotifyTarget(), "NotifyTarget");
        // 啟動執行緒
        waitThread.start();
        Thread.sleep(1000);
        notifyThread.start();
    }
}
