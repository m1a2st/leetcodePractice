package practice.leetcode.data_structure.sort;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class ShellSort {

    /**
     * 交換法（不好），速度很慢
     *
     * @param arr 想要被排序的陣列
     */
    public static void shellSort(int[] arr) {
        //增量gap，並逐漸縮小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int groupIndex = gap; groupIndex < arr.length; groupIndex++) {
                //遍歷各組中所有的元素，（共5組，每組有2個元素），步長
                for (int itemIndex = groupIndex - gap; itemIndex >= 0; itemIndex -= gap) {
                    //如果當前元素大於加上步長後的那個元素，表示要交換
                    if (arr[itemIndex] > arr[itemIndex + gap]) {
                        //交換
                        int temp = arr[itemIndex];
                        arr[itemIndex] = arr[itemIndex + gap];
                        arr[itemIndex + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 插入法
     * 說明：
     * 1. 先把想要排序的陣列一分為二
     * 2. 遍歷每一個分組裡面的每一個數字
     * 3. 接著使用插入排序把數字排序好
     *
     * @param arr 想要被排序的陣列
     */
    public static void shellSortFast(int[] arr) {
        //增量gap，並逐漸縮小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int groupIndex = gap; groupIndex < arr.length; groupIndex++) {
                int insertIndex = groupIndex;
                int insertVal = arr[insertIndex];
                if (arr[insertIndex] < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                        //移動
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    //當退出while循環後，就找到temp的插入位置
                    if (insertIndex - gap != groupIndex) {
                        arr[insertIndex] = insertVal;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
        shellSortFast(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
    }
}
