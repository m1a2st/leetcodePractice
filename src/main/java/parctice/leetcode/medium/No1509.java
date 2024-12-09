package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No1509 {
    
    @Test
    public void test() {
        int[] nums = {1, 5, 0, 10, 14, 15, 13, 10, 3, 6};
        System.out.println(new Solution().minDifference(nums));
    }

    class Solution {
        public int minDifference(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            if (len <= 4) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                min = Math.min(min, nums[len - 4 + i] - nums[i]);
            }
            return min;
        }       
    }
}
