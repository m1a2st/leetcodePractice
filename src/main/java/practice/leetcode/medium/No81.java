package practice.leetcode.medium;

import java.util.Arrays;

public class No81 {

    class Solution {
        public boolean search(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0, right = nums.length;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }

    class SolutionNew {
        public boolean search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            while (l <= r) {
                final int m = (l + r) / 2;
                if (nums[m] == target)
                    return true;
                if (nums[l] == nums[m] && nums[m] == nums[r]) {
                    ++l;
                    --r;
                } else if (nums[l] <= nums[m]) { // nums[l..m] are sorted
                    if (nums[l] <= target && target < nums[m])
                        r = m - 1;
                    else
                        l = m + 1;
                } else { // nums[m..n - 1] are sorted
                    if (nums[m] < target && target <= nums[r])
                        l = m + 1;
                    else
                        r = m - 1;
                }
            }

            return false;
        }
    }
}
