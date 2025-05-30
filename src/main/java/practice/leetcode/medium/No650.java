package practice.leetcode.medium;

public class No650 {

    class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n + 1];
            // the screen already has one 'A'
            dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = i / 2; j >= 2; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + i / j;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
