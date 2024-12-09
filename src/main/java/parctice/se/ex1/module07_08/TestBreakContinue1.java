package main.java.parctice.se.ex1.module07_08;

/*
 * 迴圈搭配break與標籤的範例說明
 */
public class TestBreakContinue1 {

    public static void main(String[] args) {
        int i = 1;
        int j;

        outer:
        //label 標籤
        while (i <= 3) {
            i++;
            j = 0;
            while (j <= 5) {
                j++;
                if (j == 4) {
                    break outer;
                }
                System.out.println(j);
            }
        }
    }

}
