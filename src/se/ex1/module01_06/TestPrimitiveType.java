package se.ex1.module01_06;

/*
 * 此範例為練習基本型態變數宣告與初始化
 * 並留意基本型態的細節內容
 */
public class TestPrimitiveType {

    public static void main(String[] args) {
        // 整數型態
        byte num1 = 1;
        short num2 = 2;
        int num3 = 3;
        long num4 = 4;
        int num5 = 0x8e;  // 十六進位整數表示
        int num6 = 0b0010;  // JDK 7以後可使用二進位整數表示
        int num7 = 1_000_000;  // JDK 7以後可使用底線將數值隔開

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(num7);
        System.out.println("==============");

        // 浮點數型態
        float num8 = 1.0f;  // f代表指定為float型態
        double num9 = 2.0;
        float num10 = 1234567890;
        double num11 = 1234567890;

        System.out.println(num8);
        System.out.println(num9);
        System.out.println(num10);
        System.out.println(num11);
        System.out.println("==============");

        // 其它型態
        boolean b = true;
        char ch1 = 'A';
        char ch2 = '我';
        int i1 = ch1;
        int i2 = ch2;
        char ch3 = '\u0041';    //參考Unicode表：http://www.tamasoft.co.jp/en/general-info/unicode.html
        String s1 = "Java";
        String s2 = "\"Java\"";

        System.out.println(b);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(ch3);
        System.out.println(s1);
        System.out.println(s2);

    }

}
