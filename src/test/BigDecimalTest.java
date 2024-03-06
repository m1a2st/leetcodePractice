package test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal("1234567890");
        BigDecimal divide = bigDecimal.divide(new BigDecimal("1000"), MathContext.DECIMAL64);
        System.out.println(divide);
    }
}
