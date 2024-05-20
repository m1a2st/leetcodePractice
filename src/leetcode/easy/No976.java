package leetcode.easy;

import java.util.Arrays;

public class No976 {
    //simple answer
    public static int largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            if (istriangle(arr[i], arr[i - 1], arr[i - 2])) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }
        return 0;
    }

    //best answer
    public static int largestPerimeterBest(int[] arr) {
        //把最大值移到索引值最後一位
        swapMaxNumber(arr, arr.length - 1);
        swapMaxNumber(arr, arr.length - 2);
        for (int i = arr.length - 1; i > 1; i--) {
            swapMaxNumber(arr, i - 2);
            if (istriangle(arr[i], arr[i - 1], arr[i - 2])) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }
        return 0;
    }

    public static boolean istriangle(int longSide, int shortSide, int shortSide2) {
        return longSide < shortSide + shortSide2;
    }

    /**
     * 將一個陣列某個索引前的最大值調換到指定的索引值
     *
     * @param arr
     * @param index
     */
    public static void swapMaxNumber(int[] arr, int index) {
        // 先假設此陣列第一個數字為最大值
        int max = arr[0];
        // 最大值的索引值
        int maxIndex = 0;
        // serch the biggest number and index.
        for (int i = 1; i <= index; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        // swap
        arr[maxIndex] = arr[index];
        arr[index] = max;
    }
}
