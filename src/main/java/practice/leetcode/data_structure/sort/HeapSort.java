package practice.leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class HeapSort {

    @Test
    public void test() {
        int[] arr = {8, 7, 44, 32, 5, 6, 3, 0, 1, 33, 123, 100, 45};
        _heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 將待排序序列構造成一個大頂堆。
     * 此時，整個序列的最大值就是堆頂的根節點。
     * 將其與末尾元素進行交換，此時末尾就為最大值。
     * 然後將剩餘n-1個元素重新構造成一個堆，這樣會得到n個元素的次小值。如此反覆執行，便能得到一個有序序列了。
     *
     * @param arr 待調整的陣列
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 將一個陣列，調整成一個大頂堆
     * 功能：將以 noLeafNodeIndex 對應非葉子節點調整成大頂堆
     * 舉例：int[] arr = {4, 6, 8, 5, 9} => noLeafNodeIndex = 1 => adjustHeap => {4, 9, 8, 5, 6}
     * 如果再次調用 adjustHeap 傳入的是 {4, 9, 8, 5, 6} => noLeafNodeIndex = 0 => {9, 6, 8, 5, 4}
     *
     * @param arr             待調整的陣列
     * @param noLeafNodeIndex 表示非葉子節點在陣列的索引
     * @param length          表示對多少個元素繼續調整，length會逐漸減少
     */
    public static void adjustHeap(int[] arr, int noLeafNodeIndex, int length) {
        int temp = arr[noLeafNodeIndex];//先取出當前元素的值，保存在臨時變量

        //leftNodeIndex = noLeafNodeIndex * 2 + 1是noLeafNodeIndex的左子節點
        for (int leftNodeIndex = noLeafNodeIndex * 2 + 1; leftNodeIndex < length;
             leftNodeIndex = leftNodeIndex * 2 + 1) {
            if (leftNodeIndex + 1 < length && arr[leftNodeIndex] < arr[leftNodeIndex + 1]) {//說明左子節點的值小於右子節點
                leftNodeIndex++;
            }
            if (arr[leftNodeIndex] > temp) {//如果子節點大於父節點
                arr[noLeafNodeIndex] = arr[leftNodeIndex];//把較大的值賦給當前節點
                noLeafNodeIndex = leftNodeIndex;//noLeafNodeIndex指向leftNodeIndex，繼續循環比較
            } else {
                break;
            }
        }
        //當for循環結束後，我們已經將以noLeafNodeIndex為父節點的樹之最大值，放在了最頂部（局部）
        arr[noLeafNodeIndex] = temp; //將temp值放到調整後的位置
    }

    private void _heapSort(int[] arr) {
        // 先調整成一個大頂堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            _adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            _adjustHeap(arr, 0, i);
        }
    }

    private void _adjustHeap(int[] arr, int noLeafNodeIndex, int length) {
        int temp = arr[noLeafNodeIndex];

        for (int leftNodeIndex = noLeafNodeIndex * 2 + 1; leftNodeIndex < length;
             leftNodeIndex = leftNodeIndex * 2 + 1) {
            int rightNodeIndex = leftNodeIndex + 1;
            int biggestNodeIndex = leftNodeIndex;
            if (rightNodeIndex < length && arr[rightNodeIndex] > arr[leftNodeIndex]) {
                biggestNodeIndex = rightNodeIndex;
            }
            if (arr[biggestNodeIndex] > temp) {
                arr[noLeafNodeIndex] = arr[biggestNodeIndex];
                // 將指針變成新的父節點，繼續往下一個子樹比較
                noLeafNodeIndex = biggestNodeIndex;
                // 要注意，這邊需要重新更新 leftNodeIndex 的值，繼續遍歷的索引才會正確
                leftNodeIndex = biggestNodeIndex;
            } else {
                break;
            }
        }
        arr[noLeafNodeIndex] = temp;
    }
}
