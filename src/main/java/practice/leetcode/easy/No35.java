package practice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] == target) {
                    return m;
                }
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }

    class SolutionNew {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (target == nums[mid]) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
