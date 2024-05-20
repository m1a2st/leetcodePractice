package leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date startTime = new Date();
        long start = startTime.getTime();
        quickSort(arr, 0, arr.length - 1);
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        int lIndex = leftIndex;//左下標
        int rIndex = rightIndex;//右下標
        int temp; //交換時使用
        //pivot 中軸
        int pivot = arr[(leftIndex + rightIndex) / 2];
        //while的循環的目的，是讓比pivot值小放到左邊，比pivot值大放到右邊
        while (lIndex < rIndex) {
            //在pivot的左邊一直找，找到大於等於pivot值，才退出
            while (arr[lIndex] < pivot) {
                lIndex += 1;
            }
            //在pivot的右邊一直找，找到小於等於pivot值，才退出
            while (arr[rIndex] > pivot) {
                rIndex -= 1;
            }
            //如果 lIndex >= rIndex 說明pivot的左右兩側的值，
            // 已經按照左邊全部都是小於pivot值，右邊全部都是大於等於pivot值
            if (lIndex >= rIndex) {
                break;
            }
            //交換
            temp = arr[lIndex];
            arr[lIndex] = arr[rIndex];
            arr[rIndex] = temp;

            //如果交換完後，發現arr[lIndex] == pivot值 相等 --，前移
            if (arr[lIndex] == pivot) {
                rIndex -= 1;
            }
            //如果交換完後，發現arr[rIndex] == pivot值 相等 ++，後移
            if (arr[rIndex] == pivot) {
                lIndex += 1;
            }
        }
        //如果 lIndex == rIndex ，必須 lIndex++，rIndex--，否則會出現棧溢出
        if (lIndex == rIndex) {
            lIndex += 1;
            rIndex -= 1;
        }
        //向左遞迴
        if (leftIndex < rIndex) {
            quickSort(arr, leftIndex, rIndex);
        }
        //向右遞迴
        if (rightIndex > lIndex) {
            quickSort(arr, lIndex, rightIndex);
        }
    }

    @Test
    public void test() {
        int[] arr = {8, 7, 44, 32, 5, 6, 3, 0, 1, 33};
        quickSortP(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void quickSortPractice(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSortPractice(arr, left, pivot - 1);
            quickSortPractice(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(int[] arr, int lIndex, int rIndex) {
        int temp = arr[lIndex];
        arr[lIndex] = arr[rIndex];
        arr[rIndex] = temp;
    }


    public void quickSortP(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partitionP(arr, left, right);
            quickSortP(arr, left, partition - 1);
            quickSortP(arr, partition + 1, right);
        }
    }

    private int partitionP(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

}
