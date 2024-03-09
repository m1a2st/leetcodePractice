package leecode.data_structure.search;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int i = fibSearch(arr, 8);
        System.out.println(i);
    }

    /**
     * 費波那契數列（使用非遞迴實現）
     *
     * @param size 產生的陣列長度
     * @return 費波那契數列
     */
    public static int[] fib(int size) {
        int[] result = new int[size];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < size; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    /**
     * 費波那契搜尋法（使用非遞迴實現）
     *
     * @param arr    欲被搜尋的陣列
     * @param target 要查找的值
     * @return 如果找到就返回位置，沒有找到就返回-1
     */
    public static int fibSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int targetIndex = 0; //表示費波那契分割數值的索引
        int mid; //存放mid值
        int[] fib = fib(10); //獲取費波那契數列
        //獲取到費波那契分割數值的索引
        while (high > fib[targetIndex] - 1) {
            targetIndex++;
        }
        //因為f[k]值可能大於a的長度，因此需要使用Arrays累，構造一個新的陣列，並指向temp[]
        //不足的部分使用填充
        int[] temp = Arrays.copyOf(arr, fib[targetIndex]);
        //實際上需要使用arr陣列最後的數據填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //使用while來循環處理，找到target
        while (low <= high) {
            //只要這個條件滿足，就可以找
            mid = low + fib[targetIndex - 1] - 1;
            //說明應該繼續向陣列的前部分搜尋（左邊）
            if (target < temp[mid]) {
                high = mid - 1;
                /*
                    targetIndex--;
                    說明：
                    1. 全部元素 = 前面元素 + 後面元素
                    2. fib[targetIndex] = fib[targetIndex - 1] + fib[targetIndex -2]
                    3. 因為前面有fib[targetIndex - 1]個元素，所以可以繼續拆分
                       fib[targetIndex - 1] = fib[targetIndex - 2] + fib[targetIndex - 3]
                    4. 即在 fib[targetIndex - 1]的前面繼續搜尋 targetIndex--
                    5. 即下次循環 mid = fib[targetIndex - 1 - 1] - 1
                */
                targetIndex--;
            } else if (target > temp[mid]) {
                //應該繼續搜尋陣列後面（右邊）
                low = mid + 1;
                /*
                    targetIndex-=2;
                    1. 全部元素 = 前面元素 + 後面元素
                    2. fib[targetIndex] = fib[targetIndex - 1] + fib[targetIndex -2]
                    3. 因為後面有fib[targetIndex - 2]個元素，所以可以繼續拆分
                       fib[targetIndex - 1] = fib[targetIndex - 3] + fib[targetIndex - 4]
                    4. 即在 fib[targetIndex - 2]的前面繼續搜尋 targetIndex-=2
                    5. 即下次循環 mid = fib[targetIndex - 1 - 2] - 1
                */
                targetIndex -= 2;
            } else {
                //找到，需要確定返回的是哪個索引
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}
