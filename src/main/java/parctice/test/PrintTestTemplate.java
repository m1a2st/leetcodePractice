package parctice.test;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PrintTestTemplate implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Test finished");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Test started");
    }
}
