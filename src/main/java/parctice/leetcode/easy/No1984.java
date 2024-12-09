package parctice.leetcode.easy;

import java.util.Arrays;

public class No1984 {

    private int min;

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            if (nums.length == 1) return nums[0];
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - k + 1; i++) {
                int diff = nums[i] - nums[i + k - 1];
                min = Math.min(min, diff);
            }
            return min;
        }
    }


}
