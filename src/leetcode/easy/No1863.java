package leetcode.easy;

public class No1863 {

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
