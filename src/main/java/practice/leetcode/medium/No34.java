package practice.leetcode.medium;

public class No34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1};
            int len = nums.length;
            int left = 0, right = len;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    int start = mid, end = mid;
                    while (start >= 0 && nums[start] == nums[mid]) {
                        start--;
                    }
                    while (end < len && nums[end] == nums[mid]) {
                        end++;
                    }
                    ans[0] = start + 1;
                    ans[1] = end - 1;
                    break;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
}
