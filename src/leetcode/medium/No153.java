package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No153 {

    static class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;
            int left = 0, right = len;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] > nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(11, solution.findMin(new int[]{11, 13, 15, 17}));
    }
}
