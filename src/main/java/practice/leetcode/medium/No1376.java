package practice.leetcode.medium;

import java.util.Arrays;

public class No1376 {

    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            dp[headID] = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (dp[i] == -1) {
                    dfs(i, manager, informTime, dp);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        private void dfs(int i, int[] manager, int[] informTime, int[] dp) {
            if (dp[i] != -1) {
                return;
            }
            dfs(manager[i], manager, informTime, dp);
            dp[i] = dp[manager[i]] + informTime[manager[i]];
        }
    }
}
