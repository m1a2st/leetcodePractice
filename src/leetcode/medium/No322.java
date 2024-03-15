package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Math.min;

public class No322 {

    @Test
    public void test() {
        new Solution().coinChange(new int[]{1, 2, 5}, 11);
    }

    class Solution {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -100);
            // 題目最後要求的結果是dp(amount)
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            // base case
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            if (memo[amount] != -100) {
                return memo[amount];
            }

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 計算子問題的結果
                int subProblem = dp(coins, amount - coin);
                // 如果子問題無解
                if (subProblem == -1) continue;
                // 在子問題中選擇最優解，並且+1
                res = min(res, subProblem + 1);
            }
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

    class SolutionBottonUp {

        int[] dp;

        public int coinChange(int[] coins, int amount) {
            dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - amount < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }

    class SolutionBP {

        int[] dp;

        public int coinChange(int[] coins, int amount) {
            dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount - 1 ? -1 : dp[amount];
        }
    }
}
