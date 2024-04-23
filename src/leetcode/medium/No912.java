package leetcode.medium;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No912 {

    class Solution {
        public int[] sortArray(int[] nums) {
            int[] temp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, temp);
            return nums;
        }

        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(nums, left, mid, temp);
                mergeSort(nums, mid + 1, right, temp);
                merge(nums, left, mid, right, temp);
            }
        }

        private void merge(int[] nums, int left, int mid, int right, int[] temp) {
            int i = left;
            int j = mid + 1;
            int k = left;

            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = nums[i++];
            }

            while (j <= right) {
                temp[k++] = nums[j++];
            }

            for (k = left; k <= right; k++) {
                nums[k] = temp[k];
            }
        }
    }


    @Test
    public void test() {
        new SolutionNew().sortArray(new int[]{5, 2, 3, 1, 4, 6});
    }

    class SolutionNew {
        public int[] sortArray(int[] nums) {
            mergeSort(nums);
            return nums;
        }

        private void mergeSort(int[] nums) {
            int len = nums.length;
            if (len > 1) {
                int[] frontHalf = new int[len / 2];
                System.arraycopy(nums, 0, frontHalf, 0, len / 2);
                mergeSort(frontHalf);
                int[] backHalf = new int[len - len / 2];
                System.arraycopy(nums, len / 2, backHalf, 0, len - len / 2);
                mergeSort(backHalf);
                merge(frontHalf, backHalf, nums);
            }
        }

        private void merge(int[] frontSort, int[] backSort, int[] nums) {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < frontSort.length && j < backSort.length) {
                if (frontSort[i] < backSort[j]) {
                    nums[k++] = frontSort[i++];
                } else {
                    nums[k++] = backSort[j++];
                }
            }
            while (i < frontSort.length) {
                nums[k++] = frontSort[i++];
            }
            while (j < backSort.length) {
                nums[k++] = backSort[j++];
            }
        }
    }
}
