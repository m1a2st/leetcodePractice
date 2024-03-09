package leecode.data_structure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 使用二分搜尋法的前提是，陣列是有序的
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 9, 10};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
        System.out.println(binarySearchMul(arr, 0, arr.length - 1, 8));
    }

    /**
     * 二元搜尋法
     *
     * @param arr    欲被搜尋的陣列
     * @param right  左邊索引
     * @param left   右邊索引
     * @param target 要查找的值
     * @return 如果找到就返回位置，沒有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        //當left > right時，說明遞迴整個陣列，但是沒有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal) {
            //向右遞迴
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < midVal) {
            //向左遞迴
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }

    /**
     * 可以搜尋多個相同的數的索引值
     * 思路分析
     * 1. 在找到mid索引值，不要馬上返回
     * 2. 向mid索引值的左邊掃描，將所有滿足1000，的元素索引，加入到ArrayList
     * 3. 向mid索引值的右邊掃描，將所有滿足1000，的元素索引，加入到ArrayList
     * 4. 將ArrayList返回
     *
     * @param arr    欲被搜尋的陣列
     * @param right  左邊索引
     * @param left   右邊索引
     * @param target 要查找的值
     * @return 如果找到就返回位置，沒有找到就返回空List
     */
    public static List<Integer> binarySearchMul(int[] arr, int left, int right, int target) {
        //當left > right時，說明遞迴整個陣列，但是沒有找到
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal) {
            //向右遞迴
            return binarySearchMul(arr, mid + 1, right, target);
        } else if (target < midVal) {
            //向左遞迴
            return binarySearchMul(arr, left, mid - 1, target);
        } else {
            ArrayList<Integer> resultIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == target) {
                resultIndexList.add(temp);
                temp--;
            }
            resultIndexList.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == target) {
                resultIndexList.add(temp);
                temp++;
            }
            return resultIndexList;
        }
    }
}
