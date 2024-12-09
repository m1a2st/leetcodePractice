package main.java.parctice.thread.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteRockTest {

    private static final Map<String, String> MAP = new HashMap<>();
    // 創建讀寫鎖
    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    // 獲取讀鎖
    final static Lock READ_LOCK = LOCK.readLock();
    // 獲取寫鎖
    final static Lock WRITE_LOCK = LOCK.writeLock();

    // 對共享數據的寫操作
    public static Object put(String key, String value) {
        WRITE_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " write start");
            Thread.sleep(1000);
            return MAP.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    public static Object get(String key) {
        READ_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read start");
            Thread.sleep(1000);
            return MAP.get(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            READ_LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable writeTarget = () -> put("key", "value");
        Runnable readTarget = () -> get("key");
        for (int i = 0; i < 4; i++) {
            new Thread(writeTarget, "讀執行緒" + i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(readTarget, "寫執行緒" + i).start();
        }
    }
}
