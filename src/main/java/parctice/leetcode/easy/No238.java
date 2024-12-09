package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No238 {

    @Test
    public void test0() {
        int[] nums = {1, 0, 1};
        new Solution().moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
