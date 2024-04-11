package thread.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {

    static class Foo {
        // 實例總數
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        // 對象的編號
        int index = 0;
        // 對象的內容
        int bar = 10;

        public Foo() {
            index = AMOUNT.incrementAndGet();
        }

        @Override
        public String toString() {
            return index + "@Foo{ bar=" + bar + " }";
        }
    }

    public static final ThreadLocal<Foo> THREAD_LOCAL = new ThreadLocal();

    public static void main(String[] args) {
        // 獲取自定義的混合線程池
    }
}
