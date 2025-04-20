package practice.leetcode.medium;


import org.junit.jupiter.api.Test;

public class No912 {

    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = {5, 2, 3, 1};
        int[] result = s.sortArray(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums);
            return nums;
        }

        private void mergeSort(int[] nums) {
            int len = nums.length;
            if (len > 1) {
                int mid = len / 2;
                int[] left = new int[mid];
                System.arraycopy(nums, 0, left, 0, mid);
                mergeSort(left);
                int rightLen = len - mid;
                int[] right = new int[rightLen];
                System.arraycopy(nums, mid, right, 0, rightLen);
                mergeSort(right);
                merge(nums, left, right);
            }
        }

        private void merge(int[] nums, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    nums[k++] = left[i++];
                } else {
                    nums[k++] = right[j++];
                }
            }
            while (i < left.length) {
                nums[k++] = left[i++];
            }
            while (j < right.length) {
                nums[k++] = right[j++];
            }
        }
    }
}
