package parctice.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.fail;

/**
 There are six conditions:
 1. future is cancel: It will fail at L603, the error message is `Expected NullPointerException, but got java.util.concurrent.CancellationException`
 2. future is timeout: It will fail at L609, the error message is `Future is not completed within 15000 millisecond.`
 3. future is interrupt: It will fail at L603, the error message is `Expected NullPointerException, but got java.lang.InterruptedException`
 4. future is completed without any exception: It will fail at L600, The error message is `Should throw expected exception NullPointerException but nothing was thrown.`
 5. future throw unexcepted exception: It will fail at L603, the error message is `Expected NullPointerException, but got java.lang.RuntimeException`
 6. future throw excepted exception: pass this assertion
 */
public class TestClass {

    
    @Test
    void testFutureInterrupted() {
        FutureTask<String> future = new FutureTask<>(() -> {
            Thread.sleep(Long.MAX_VALUE);
            return "result";
        });

        Thread currentThread = Thread.currentThread();
        Thread interrupter = new Thread(() -> {
            try {
                Thread.sleep(100); // 等待一小段時間
                currentThread.interrupt();
            } catch (InterruptedException e) {
                // ignore
            }
        });

        interrupter.start();
        assertFutureThrows(future, NullPointerException.class);
    }

    @Test
    void testFutureSuccess() {
        CompletableFuture<String> future = CompletableFuture.completedFuture("success");
        assertFutureThrows(future, NullPointerException.class);
    }

    @Test
    void testFutureThrowsNullException() {
        CompletableFuture<String> future = CompletableFuture.failedFuture(
                new NullPointerException("Expected exception"));

        assertFutureThrows(future, NullPointerException.class);
    }

    @Test
    void testFutureThrowsRuntimeException() {
        CompletableFuture<String> future = CompletableFuture.failedFuture(
                new RuntimeException("Expected exception"));

        assertFutureThrows(future, NullPointerException.class);
    }

    @Test
    void testFutureCancelled() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            future.cancel(true);
        }).start();
        assertFutureThrows(future, NullPointerException.class);
    }

    @Test
    void testFutureTimeout() {
        CompletableFuture<String> future = new CompletableFuture<>();
        assertFutureThrows(future, NullPointerException.class);
    }

    public static <T extends Throwable> T assertFutureThrows(Future<?> future, Class<T> exceptionCauseClass) {
        try {
            future.get(10000, TimeUnit.MILLISECONDS);
            fail("Should throw expected exception " + exceptionCauseClass.getSimpleName() + " but nothing was thrown.");
        } catch (ExecutionException e) {
            assertInstanceOf(
                exceptionCauseClass, e.getCause(),
                "Expected " + exceptionCauseClass.getSimpleName() + ", but got " + e.getCause()
            );
            return exceptionCauseClass.cast(e.getCause());
        } catch (InterruptedException | CancellationException e) {
            assertInstanceOf(
                exceptionCauseClass, e,
                "Expected " + exceptionCauseClass.getSimpleName() + ", but got " + e
            );
            return exceptionCauseClass.cast(e);
        } catch (TimeoutException e) {
            fail("Future is not completed within " + 10000 + " millisecond.");
        }
        throw new RuntimeException("Future should throw expected exception but unexpected error happened.");
    }
}
