package main.java.parctice.se.ex1.module01_06;

/*
 * 以下為位元運算測試
 * 需將1(十位數)轉換成二進位，以8個bits表示
 * 也就是 0000 0001
 */
public class TestBitOP {

    public static void main(String[] args) {
        // AND運算
        System.out.println(0 & 1);
        System.out.println(0 & 0);
        System.out.println(1 & 0);
        System.out.println(1 & 1);
        System.out.println("===========");
        // OR運算
        System.out.println(0 | 1);
        System.out.println(0 | 0);
        System.out.println(1 | 0);
        System.out.println(1 | 1);
        System.out.println("===========");
        // XOR運算
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);
        System.out.println("===========");
        // 位元反轉
        System.out.println(~0);
    }

}
