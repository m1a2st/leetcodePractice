package main.java.parctice.leetcode.data_structure.commomAlogrithm;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(arr, 1));

    }


    /**
     * 二分查找（非遞迴）
     *
     * @param arr    待搜尋的陣列
     * @param target 需要查找的數
     * @return 對應的索引，-12代表沒找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; //需要向左查找

            } else {
                left = mid + 1; //需要向右尋找
            }
        }
        return -1;
    }
}

class A {
    public static void doSomething() {

    }

    public void doSomethings() {

    }
}
