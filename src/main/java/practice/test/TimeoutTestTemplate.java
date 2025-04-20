package practice.test;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimeoutTestTemplate implements BeforeEachCallback, AfterEachCallback {
    
    long currentTime;
    long testTime;

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (testTime != 0 && System.currentTimeMillis() > testTime) {
            throw new RuntimeException("Test timed out");
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        currentTime = System.currentTimeMillis();
        TimeoutTest annotation = context.getRequiredTestMethod().getAnnotation(TimeoutTest.class);
        if (annotation != null) {
            long timeout = Long.parseLong(annotation.timeout());
            String timeUnit = annotation.timeUnit();
            switch (timeUnit) {
                case "SECONDS":
                    timeout *= 1000;
                    break;
                case "MINUTES":
                    timeout *= 60000;
                    break;
                case "HOURS":
                    timeout *= 3600000;
                    break;
                case "DAYS":
                    timeout *= 86400000;
                    break;
            }
            testTime = currentTime + timeout;
        }
    }
}
