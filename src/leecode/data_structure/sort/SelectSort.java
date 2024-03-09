package leecode.data_structure.sort;

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
}
