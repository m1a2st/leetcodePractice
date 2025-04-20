package practice.thread.basic;

import java.util.concurrent.locks.LockSupport;


public class ThreadUtil {

    public static void sleepMilliSeconds(long milliseconds) {
        LockSupport.parkNanos(milliseconds * 1_000_000);
    }

}
