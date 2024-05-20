package thread.basic;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {

    // CPU 核數
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    // IO 處理線程數
    private static final int IO_MAX = Math.max(2, CPU_COUNT * 2);
    // 空間保活實現，單位為秒
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int QUEUE_SIZE = 30;

    public static class CustomThreadFactory implements ThreadFactory {
        // 線程池數量
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;

        //线程数量
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String threadTag;

        public CustomThreadFactory(String threadTag) {
            group = Thread.currentThread().getThreadGroup();
            this.threadTag = "apppool-" + poolNumber.getAndIncrement() + "-" + threadTag + "-";
        }

        @Override
        public Thread newThread(@Nonnull Runnable target) {
            Thread t = new Thread(group, target,
                    threadTag + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    private static class IoIntenseTargetThreadPoolLazyHolder {
        // 線程池
        private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
                IO_MAX,
                IO_MAX,
                KEEP_ALIVE_SECONDS,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(QUEUE_SIZE),
                new CustomThreadFactory("io")
        );

        static {
            EXECUTOR.allowCoreThreadTimeOut(true);
            Runtime.getRuntime()
                    .addShutdownHook(new ShutdownHookThread<Void>("IO密集型任務線程池", () -> {
                        // 優雅關閉線程池
                        shutdownThreadPoolGracefully(EXECUTOR);
                        return null;
                    }));
        }
    }

    public static void shutdownThreadPoolGracefully(ExecutorService threadPool) {
        if (threadPool == null || threadPool.isTerminated()) {
            return;
        }
        try {
            // 拒绝接受新任務
            threadPool.shutdown();
        } catch (SecurityException | NullPointerException e) {
            return;
        }
        try {
            // 等待 60s ，等待線程池中的任務完成執行
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                // 調用 shutdownNow 取消正在執行的任務
                threadPool.shutdownNow();
                // 再次等待 60 s，如果還未结束，可以再次嘗試，或直接放棄
                if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("線程池任務未正常執行结束");
                }
            }
        } catch (InterruptedException ie) {
            // 捕獲異常，重新调用 shutdownNow
            threadPool.shutdownNow();
        }
        // 仍然没有關閉，循環關閉 1000次，每次等待 10毫秒
        if (!threadPool.isTerminated()) {
            try {
                for (int i = 0; i < 1000; i++) {
                    if (threadPool.awaitTermination(10, TimeUnit.MILLISECONDS)) {
                        break;
                    }
                    threadPool.shutdownNow();
                }
            } catch (Throwable e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

    public static class CpuIntenseTargetThreadPoolLazyHolder {
        private static final ThreadPoolExecutor EXECUTOR =
                new ThreadPoolExecutor(MAXIMUM_POOL_SIZE,
                        MAXIMUM_POOL_SIZE,
                        KEEP_ALIVE_SECONDS,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(QUEUE_SIZE),
                        new CustomThreadFactory("cpu"));

        static {
            EXECUTOR.allowCoreThreadTimeOut(true);
            // JVM 關閉時的鉤子函數
            Runtime.getRuntime()
                    .addShutdownHook(new ShutdownHookThread<Void>("CPU密集型任務線程池", () -> {
                        // 優雅關閉線程池
                        shutdownThreadPoolGracefully(EXECUTOR);
                        return null;
                    }));
        }
    }

    // 最大線程數
    private static final int MIXED_MAX = 128;
    private static final String MIXED_THREAD_AMOUNT = "mixed.thread.amount";

    public static class MixedTargetThreadTargetLazyHolder {

        // 首先先從環境變量 mixed.thread.amount 中獲取預先配置的線程池
        // 如果沒有配置，則使用預設的線程池大小
        private static final int MAX = Objects.nonNull(System.getProperty(MIXED_THREAD_AMOUNT)) ?
                Integer.parseInt(System.getProperty(MIXED_THREAD_AMOUNT)) : MIXED_MAX;
        private static final ThreadPoolExecutor EXECUTOR =
                new ThreadPoolExecutor(MAXIMUM_POOL_SIZE,
                        MAX,
                        MAX,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(QUEUE_SIZE),
                        new CustomThreadFactory("mixed"));

        public static ThreadPoolExecutor getInnerExecutor() {
            return EXECUTOR;
        }

        static {
            EXECUTOR.allowCoreThreadTimeOut(true);
            // JVM 關閉時的鉤子函數
            Runtime.getRuntime()
                    .addShutdownHook(new ShutdownHookThread<Void>("混合型任務線程池", () -> {
                        // 優雅關閉線程池
                        shutdownThreadPoolGracefully(EXECUTOR);
                        return null;
                    }));
        }
    }
}
