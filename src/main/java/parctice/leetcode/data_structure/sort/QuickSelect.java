package parctice.leetcode.data_structure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSelect {

    @Test
    public void test() {
        int[] arr = {1, 3, 2, 9, 5, 6, 464, 35, 2, 43, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, right);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 快速選擇法(從最小開始)，使用迴圈來迭代。
     */
    public int quickSelect(final int[] array, final int index) {
        int start = 0;
        int end = array.length - 1;

        while (true) {
            if (start == end) {
                return start;
            }

            final int pivot = array[start];

            int l = start + 1;
            int r = end;

            while (true) {
                while (r > start && array[r] >= pivot) {
                    --r;
                }

                while (l <= r && array[l] <= pivot) {
                    ++l;
                }

                if (l < r) {
                    swap(array, l, r);
                } else {
                    if (r > start) {
                        swap(array, l, r);
                    }
                    break;
                }
            }

            if (index == r) {
                return index;
            } else if (index > r) {
                start = r + 1;
            } else {
                end = r - 1;
            }
        }
    }
}
