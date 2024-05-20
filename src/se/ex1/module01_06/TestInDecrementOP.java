package se.ex1.module01_06;

/*
 * 此範例為測試遞增/遞減運算子
 */
public class TestInDecrementOP {

    public static void main(String[] args) {
        int num1 = 3, num2 = 4;
        System.out.println(num1++); //3
        System.out.println(++num1); //5
        System.out.println(--num2); //3
        System.out.println(num2--); //3
        System.out.println(num1);   //5
        System.out.println(num2);  //2
    }

}
