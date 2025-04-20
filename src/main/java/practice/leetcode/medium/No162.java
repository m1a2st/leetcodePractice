package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No162 {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().findPeakElement(nums));
    }

    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid1 = (left + right) / 2;
                int mid2 = mid1 + 1;
                if (nums[mid1] < nums[mid2]) {
                    left = mid2;
                } else {
                    right = mid1;
                }
            }
            return left;
        }
    }

    class SolutionNew {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int midR = mid + 1;
                if (nums[mid] > nums[midR]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
