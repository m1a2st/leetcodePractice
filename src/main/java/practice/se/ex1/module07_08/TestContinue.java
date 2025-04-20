package practice.se.ex1.module07_08;

/*
 * 關鍵字continue在迴圈裡的用法
 */
public class TestContinue {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.println(i);
        }
    }

}
