package leetcode.data_structure.search;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 100));
    }

    /**
     * 差值搜尋法
     * 注意： target > arr[arr.length - 1] || target < arr[0]，必須要有
     * 否則得到的mid可能越界
     *
     * @param arr    欲被搜尋的陣列
     * @param right  左邊索引
     * @param left   右邊索引
     * @param target 要查找的值
     * @return 如果找到就返回位置，沒有找到就返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || target > arr[arr.length - 1] || target < arr[0]) {
            return -1;
        }

        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (target > midVal) {
            //向右遞迴
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (target < midVal) {
            //向左遞迴
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }

    }
}
