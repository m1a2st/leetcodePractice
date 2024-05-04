package thread.basic;

import java.util.concurrent.locks.Lock;

public class TwoLockDemo {

    public static void useTwoLockInterruptLock(Lock lock1, Lock lock2) {
        String lock1Name = lock1.toString().replace("java.util.concurrent.locks", "");
        String lock2Name = lock2.toString().replace("java.util.concurrent.locks", "");

        System.out.println("Thread " + Thread.currentThread().getName() + " is trying to acquire " + lock1Name);
        try {
            lock1.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted while acquiring " + lock1Name);
            return;
        }
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired " + lock1Name);
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired " + lock2Name);
            try {
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted while acquiring " + lock2Name);
                return;
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired " + lock2Name);
            System.out.println("Thread " + Thread.currentThread().getName() + " do something");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " released " + lock2Name);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            System.out.println("Thread " + Thread.currentThread().getName() + " released " + lock1Name);
        }
    }
}
