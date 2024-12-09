package main.java.parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

public class No2444 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(solution.countSubarrays(nums, minK, maxK));
    }


    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long ans = 0;
            int j = -1;
            int prevMinKIndex = -1;
            int prevMaxKIndex = -1;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] < minK || nums[i] > maxK) {
                    j = i;
                }
                if (nums[i] == minK) {
                    prevMinKIndex = i;
                }
                if (nums[i] == maxK) {
                    prevMaxKIndex = i;
                }
                ans += Math.max(0, Math.min(prevMinKIndex, prevMaxKIndex) - j);
            }

            return ans;
        }
    }
}
