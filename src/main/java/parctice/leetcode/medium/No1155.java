package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1155 {

    @Test
    public void testNumRollsToTarget() {
        Solution solution = new Solution();
        assert solution.numRollsToTarget(1, 6, 3) == 1;
        assert solution.numRollsToTarget(2, 6, 7) == 6;
        assert solution.numRollsToTarget(2, 5, 10) == 1;
        assert solution.numRollsToTarget(1, 2, 3) == 0;
        assert solution.numRollsToTarget(30, 30, 500) == 222616187;
    }

    class Solution {
        /**
         * @param n      幾次
         * @param k      幾面骰
         * @param target 目標數字
         */
        public int numRollsToTarget(int n, int k, int target) {
            long[][] dp = new long[n + 1][target + 1];
            dp[0][0] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < target + 1; j++) {
                    long sum = 0;
                    for (int x = 1; x < k + 1; x++) {
                        if (j - x >= 0) {
                            sum += dp[i - 1][j - x];
                        }
                    }
                    dp[i][j] = sum % 1000000007;
                }
            }
            return (int) (dp[n][target] % 1000000007);
        }
    }
}
