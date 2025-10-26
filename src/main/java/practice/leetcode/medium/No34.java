package practice.leetcode.medium;

public class No34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = findLeast(nums, target);
            if (left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            int right = findLeast(nums, target + 1) - 1;
            return new int[]{left, right};
        }

        private int findLeast(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
