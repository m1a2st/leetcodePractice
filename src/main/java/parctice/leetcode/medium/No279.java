package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No279 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }


    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
