package se.ex1.module12_15;

/*
 * 二維陣列的應用示範
 */
public class TestTwoDimArray {

    public static void main(String[] args) {

        int[][] intArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++)
                sum += intArray[i][j];
        }
        System.out.println("總合 = " + sum);
    }

}
