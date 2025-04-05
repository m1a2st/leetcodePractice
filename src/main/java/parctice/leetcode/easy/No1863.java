package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1863 {

    
    @Test
    public void test() {
        int[] nums = {1, 3};
        System.out.println(new Solution().subsetXORSum(nums));
    }
    
    @Test
    public void test2() {
        int[] nums = {5, 1, 6};
        System.out.println(new Solution().subsetXORSum(nums));
    }
    
    class Solution {
        public int subsetXORSum(int[] nums) {
            return dfs(nums, 0, 0);
        }

        private int dfs(int[] nums, int i, int xors) {
            if (i == nums.length)
                return xors;

            return dfs(nums, i + 1, xors) + dfs(nums, i + 1, nums[i] ^ xors);
        }
    }
}
