package main.java.parctice.se.ex1.module09_11;

/*
 * 觀察方法傳入參數之間與回傳值的對應
 */
public class TestCalculator {

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();

        int sum1 = myCalculator.sum(1, 2);
        System.out.println(sum1);

//	    float sum2 = myCalculator.sum(3.0f, 4.0f);
//	    System.out.println(sum2);

//	    float sum3 = myCalculator.sum(5, 6.0f);
//	    System.out.println(sum3);

    }

}
