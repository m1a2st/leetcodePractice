package main.java.parctice.leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class BubbleSort {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        //測試冒泡排序的速度O(n^2)
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        bubble.array = arr;
        Date startTime = new Date();
        long start = startTime.getTime();
        bubble.sort();
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }

    static class Bubble {

        public int[] array;

        /**
         * 冒泡排序的時間複雜度為O(n^2)
         * 如果我們發現在某趟排序中，沒有發生一次交換， 可以提前結束冒泡排序。
         * 1. 新增一個boolean 來判斷是否交換
         * 2. 若有進行交換，把boolean值改成true
         * 3. 若都沒有交換則排序結束
         */
        public void sort() {
            for (int i = 0; i < array.length - 1; i++) {
                boolean flag = false;
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        //若前面的數比後面大，則交換
                        int temp;
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
//            System.out.printf("第%d趟排序\n", i + 1);
//            System.out.println(Arrays.toString(array));
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {8, 7, 4, 32, 313, 5, 6, 3, 0, 1};
        bubbleSortPractice(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void bubbleSortPractice(int[] arr) {
        int len = arr.length;
        for (int j = 0; j < len; j++) {
            boolean tag = false;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    tag = true;
                }
            }
            if (!tag) {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}




