package leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        int[] temp = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date startTime = new Date();
        long start = startTime.getTime();
        mergeSort(arr, 0, arr.length - 1, temp);
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中間索引
            //向左遞迴分解
            mergeSort(arr, left, mid, temp);
            //向右遞迴分解
            mergeSort(arr, mid + 1, right, temp);
            //到合併
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合併的方法
     *
     * @param arr   排序的原始數據
     * @param left  左邊有序序列的初始索引
     * @param mid   中間索引
     * @param right 右邊索引
     * @param temp  合併過後的陣列
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化，左邊有序序列的初始索引
        int j = mid + 1; //初始化，右邊有序序列的初始索引
        int t = 0; //指向temp 數據的當前索引

        //先把左右兩邊（有序）的數據按照規則填充到temp陣列
        //直到左右兩邊的有序序列，有一邊處理完畢為止
        while (i <= mid && j <= right) {
            //如果左邊的有序陣列的當前元素，小於等於右邊有序陣列的當前元素
            //即將左邊的當前元素，填充到temp陣列
            //然後t++,i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                //反指之，即將右邊的當前元素，填充到temp陣列
                //然後t++,j++
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //把有剩餘數據的一邊的數據一次填充到temp
        while (i <= mid) {
            //左邊的有序序列還有剩餘元素，就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            //右邊的有序序列還有剩餘元素，就全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }
        //將temp陣列的元素，複製到array
        //注意，並不是每次都複製
        t = 0;
        int tempLeft = left;
        //第一次合併 tempLeft = 0, right = 1
        //第二次合併 tempLeft = 2, right = 3
        // ...
        //最後一次次合併 tempLeft = 0, right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    @Test
    public void test() {
        int[] arr = {8, 7, 44, 32, 5, 6, 3, 0, 1, 33};
        MergeSortP.mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    class MergeSortP {

        public static void mergeSort(int[] list) {
            int length = list.length;
            if (length > 1) {
                int[] firstHalf = new int[length / 2];
                System.arraycopy(list, 0, firstHalf, 0, length / 2);
                mergeSort(firstHalf);
                int[] secondHalf = new int[length - length / 2];
                System.arraycopy(list, length / 2 + 1, secondHalf, 0, length - length / 2);
                mergeSort(secondHalf);
                merge(firstHalf, secondHalf, list);
            }
        }

        public static void merge(int[] list1, int[] list2, int[] temp) {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < list1.length && j < list2.length) {
                if (list1[i] <= list2[j]) {
                    temp[k++] = list1[i++];
                } else {
                    temp[k++] = list2[j++];
                }
            }
            while (i < list1.length) {
                temp[k++] = list1[i++];
            }
            while (j < list2.length) {
                temp[k++] = list2[j++];
            }
        }
    }

}
