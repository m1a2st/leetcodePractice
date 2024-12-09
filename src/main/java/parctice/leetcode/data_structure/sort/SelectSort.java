package main.java.parctice.leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class SelectSort {

    /**
     * 選擇排序
     * 想法：
     * 1. 先找出數據的最小值
     * 2. 數據最小值跟arr[0]交換
     * 3. 接著找出扣掉第0位的最小值
     * 4. 接著數據做交換
     * 5. ....重複直到，數據排序好
     *
     * @param arr 欲排序的數據陣列
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //將最小值，放在arr[i]
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {
        //測試冒泡排序的速度O(n^2)
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date startTime = new Date();
        long start = startTime.getTime();
        selectSort(arr);
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }

    @Test
    public void test() {
        int[] arr = {8, 7, 4, 32, 313, 5, 6, 3, 0, 1};
        selectionPractice(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void selectionPractice(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
