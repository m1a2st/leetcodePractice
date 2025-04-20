package practice.thread.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CLHLock implements Lock {

    // 當前節點的執行緒本地變量
    private static final ThreadLocal<Node> curNodeLocal = new ThreadLocal<>();
    // CLHLock 隊列的尾部，使用 AtomicReference ，方便進行 CAS 操作
    private final AtomicReference<Node> tail = new AtomicReference<>(null);

    public CLHLock() {
        // 設置尾部節點
        tail.getAndSet(Node.EMPTY);
    }

    // 加鎖：將節點添加到等待隊列的尾部
    @Override
    public void lock() {
        Node curNode = new Node(true, null);
        Node preNode = tail.get();
        // CAS 自旋：將當前節點插入到隊列的尾部
        while (!tail.compareAndSet(preNode, curNode)) {
            preNode = tail.get();
        }
        // 設置前驅
        curNode.prevNode = preNode;

        // 監聽前驅節點的 locked 變量，直到其值為 false
        // 若前驅節點的 locked 狀態為 true ，則表示前一線程還在抢占或者占有鎖
        while (curNode.prevNode.locked) {
            // 讓出 CPU 時間片，提高性能
            Thread.yield();
        }

        // 能執行到這裡，說明當前線程獲取到了鎖
        curNodeLocal.set(curNode);
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

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    static class Node {
        public Node(boolean locked, Node prevNode) {
            this.locked = locked;
            this.prevNode = prevNode;
        }

        // true：當前線程正在抢占鎖、或者已經占有鎖
        // false：当前线程已经释放锁，下一个线程可以占有锁了
        volatile boolean locked;
        // 前一个节点，需要监听其locked字段
        Node prevNode;

        // 空节点
        public static final Node EMPTY =
                new Node(false, null);
    }
}
