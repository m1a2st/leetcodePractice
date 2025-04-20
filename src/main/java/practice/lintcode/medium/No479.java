package practice.lintcode.medium;

import org.junit.jupiter.api.Test;

public class No479 {

    @Test
    public void test() {
        System.out.println(new Solution().secondMax(new int[]{1, 3, 2, 4}));
        System.out.println(new Solution().secondMax(new int[]{1, 1, 2, 2}));
    }

    public class Solution {

        public int secondMax(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length - 2];
        }
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == nums.length - 2) {
                return;
            }
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] arr, int lIndex, int rIndex) {
        int temp = arr[lIndex];
        arr[lIndex] = arr[rIndex];
        arr[rIndex] = temp;
    }
}
