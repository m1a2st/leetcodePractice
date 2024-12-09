package main.java.parctice.se.ex1.module01_06;

/*
 * 此範例為測試算術運算子功能
 */
public class TestArithmeticOP {

    public static void main(String[] args) {
        int num1 = 5, num2 = 2;
        double numD = 2.0;
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2 * numD);
        System.out.println(num1 / num2);
        System.out.println(num1 / numD);
        System.out.println(num1 % num2);
        System.out.println("===============");

        //以下注意字串相加"+"
        String s1 = "現在是上午";
        int num3 = 10;
        String s2 = "點";
        System.out.println(s1 + num3 + s2);
    }

}
