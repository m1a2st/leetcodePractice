package practice.se.ex1.module07_08;

/*
 * 此範例為while迴圈測試
 */
public class TestWhile {

    public static void main(String[] args) {
        int i = 100; //設置中斷點

        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("------------------------------");

        int count = 1;
        while (count++ < 5)
            System.out.println("count = " + count);
    }

}
