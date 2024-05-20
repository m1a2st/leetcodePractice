package se.ex2.module27_33;

public class Elapsed {
    public static void main(java.lang.String[] args) {

        System.out.println("計時從1到10000的迴圈");

        // 取得迴圈開始時間(毫秒自1970年1月1日午夜至現在時間)
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 10000; i++)
            System.out.println(i);

        // 取得迴圈結束時間(毫秒自1970年1月1日午夜至現在時間)
        long end = System.currentTimeMillis();

        System.out.println("迴圈全程使用的時間(Elapsed time): " + (end - start) / 1000.0 + "秒");
    }

}
