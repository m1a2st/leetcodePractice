package parctice.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal("1234567890");
        BigDecimal divide = bigDecimal.divide(new BigDecimal("1000"), MathContext.DECIMAL64);
        System.out.println(divide);
    }
    
    @Test
    public void test2() {
        BigDecimal bigDecimal = new BigDecimal("1234");
        BigDecimal sub = new BigDecimal("0.3214321");
        BigDecimal divide = bigDecimal.multiply(sub).setScale(0, RoundingMode.HALF_UP);
        System.out.println(divide);
    }
    
    @Test
    public void test3() {
        java.lang.Class<BigDecimal> bigDecimalClass = BigDecimal.class;
    }
}
