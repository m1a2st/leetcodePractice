package practice.thread.basic;

import java.util.concurrent.locks.Lock;

public class IncrementData {
    public static int sum = 0;

    public static void lockAndFastIncrease(Lock lock) {
        // step1：抢占锁
        // System.out.println(curThreadName()+" -- 本线程开始抢占锁");
        // 如果沒有搶到鎖就不需要釋放鎖，所以不能放在 try 裡面
        lock.lock();
        try {
            //System.out.println(curThreadName()+" ^-^本线程抢到了锁");
            //step2：执行临界区代码
            sum++;
        } finally {
            //step3：释放锁
            lock.unlock();
            //System.out.println("本线程释放了锁");
        }
    }

    public static void lockAndIncrease(Lock lock) {
        System.out.println(" -- 开始抢占锁");
        lock.lock();
        try {
            System.out.println(" ^-^ 抢到了锁");
            sum++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //演示方法：可中断抢锁
    public static void lockInterruptiblyAndIncrease(Lock lock) {
        System.out.println(" 开始抢占锁");
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("抢占被中断，抢锁失败");
            // e.printStackTrace();
            return;
        }
        try {
            System.out.println("抢到了锁，同步执行1秒");
            Thread.sleep(1000);
            sum++;
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("同步执行被中断");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void tryLockAndIncrease(Lock lock) {
        if (lock.tryLock()) {
            System.out.println("本线程抢到了锁");

            try {
                Thread.sleep(100);
                sum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("本线程释放了锁");

            }
        } else {
            // perform alternative actions
            System.out.println("本线程抢锁失败");
        }
    }

}
