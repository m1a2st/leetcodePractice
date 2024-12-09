package parctice.thread.basic;

import java.util.concurrent.Callable;

public class ShutdownHookThread<T> extends Thread {

    private volatile boolean hasShutdown = false;
    private final Callable<T> callback;

    public ShutdownHookThread(String name, Callable<T> callback) {
        super("JVM退出鉤子(" + name + ")");
        this.callback = callback;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(getName() + " starting.... ");
            if (!this.hasShutdown) {
                this.hasShutdown = true;
                long beginTime = System.currentTimeMillis();
                try {
                    this.callback.call();
                } catch (Exception e) {
                    System.out.println(getName() + " error: " + e.getMessage());
                }
                long consumingTimeTotal = System.currentTimeMillis() - beginTime;
                System.out.println(getName() + "  耗时(ms): " + consumingTimeTotal);
            }
        }
    }
}
