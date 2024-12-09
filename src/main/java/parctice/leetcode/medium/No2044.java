package main.java.parctice.leetcode.medium;

import java.util.Arrays;

public class No2044 {


    class Solution {

        private int ans = 0;

        public int countMaxOrSubsets(int[] nums) {
            final int ors = Arrays.stream(nums)
                    .reduce((a, b) -> a | b).getAsInt();
            dfs(nums, 0, 0, ors);
            return ans;
        }

        private void dfs(int[] nums, int i, int path, final int ors) {
            if (i == nums.length) {
                if (path == ors)
                    ++ans;
                return;
            }

            dfs(nums, i + 1, path, ors);
            dfs(nums, i + 1, path | nums[i], ors);
        }
    }
}
