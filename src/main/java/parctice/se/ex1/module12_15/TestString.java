package parctice.se.ex1.module12_15;

/*
 * 此範例為字串比對測試並建立觀念
 * 另示範字串常用方法供做參考
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = "Hello", s2 = "Hello";
        String s3 = "Hello";
        String s4 = " ";
        String s5 = " Hello ";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));


        System.out.println("===============");

        // 以下為字串常用方法示範
        System.out.println(s1.charAt(4));  // 注意：索引從0開始
        System.out.println(s1.length());
        System.out.println(s4.isEmpty());
        System.out.println(s1.substring(1));  // 注意：索引從0開始
        System.out.println(s1.substring(1, 4));  // 注意：索引從0開始
        System.out.println(s1.compareTo(s4));
        // 若回傳值=0，表示兩個字串相等
        // 若回傳值>0，表示左邊字串大於右邊字串
        // 若回傳值<0，表示左邊字串小於右邊字串
        System.out.println(s5.trim());  // trim()：頭尾空白都去掉

    }

}
