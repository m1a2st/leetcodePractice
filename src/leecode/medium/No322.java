package leecode.medium;

import java.util.Arrays;

import static java.lang.Math.min;

public class No322 {

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

            if(memo[amount] != -100){
                return memo[amount];
            }

            int res = Integer.MAX_VALUE;
            for(int coin : coins){
                // 計算子問題的結果
                int subProblem = dp(coins ,amount - coin);
                // 如果子問題無解
                if(subProblem == -1) continue;
                // 在子問題中選擇最優解，並且+1
                res = min(res, subProblem +1);
            }
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }
}
