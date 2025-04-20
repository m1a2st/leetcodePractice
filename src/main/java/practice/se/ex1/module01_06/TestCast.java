package practice.se.ex1.module01_06;

/*
 * 此範例為測為型別晉升與型別轉換
 */
public class TestCast {

    public static void main(String[] args) {
        int i = 1;
        double d = 11.1;
        double sum1 = i + d;
        int sum2 = (int) (i + d);
        System.out.println(sum1);
        System.out.println(sum2);
    }

}
