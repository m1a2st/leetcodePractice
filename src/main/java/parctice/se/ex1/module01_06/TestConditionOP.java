package main.java.parctice.se.ex1.module01_06;

/*
 * 此範例為條件運算子測試
 * 可自行更換變數的值以比較不同結果
 */
public class TestConditionOP {

    public static void main(String[] args) {
        int num1 = 3, num2 = 4;
        System.out.println(num1 > num2 && num1 != num2);
        System.out.println(num1 > num2 || num1 != num2);
        System.out.println(!(num1 > num2));
    }

}
