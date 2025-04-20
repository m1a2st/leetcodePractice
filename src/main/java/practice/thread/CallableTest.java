package practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author m1a2st
 * @Date 2023/8/13
 * @Version v1.0
 */
public class CallableTest implements Callable<String> {

    private final String msg;
    private final long sleepTime;

    public CallableTest(String msg, long sleepTime) {
        this.msg = msg;
        this.sleepTime = sleepTime;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(sleepTime);
        return msg;
    }
}

class CallableTestMain {
    public static void main(String[] args) throws Exception {
        CallableTest callableTest1 = new CallableTest("a", 1000);
        CallableTest callableTest2 = new CallableTest("b", 2000);
        CallableTest callableTest3 = new CallableTest("c", 3000);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(callableTest1);
        Future<String> future2 = executorService.submit(callableTest2);
        Future<String> future3 = executorService.submit(callableTest3);
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        executorService.shutdown();
    }
}
