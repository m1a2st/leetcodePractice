package main.java.parctice.test;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TimeoutTestTemplate.class, PrintTestTemplate.class})
public class Junit5Test {
    
    @TimeoutTest(timeout = "1", timeUnit = "SECONDS")
    public void test() {
        // test code
    }
    
    @TimeoutTest(timeout = "5", timeUnit = "SECONDS")
    public void test2() throws InterruptedException {
        // test code
        Thread.sleep(7000);
    }
}
