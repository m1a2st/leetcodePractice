package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No264 {
    
    @Test
    void test() {
        int n = 10;
        System.out.println(new Solution().nthUglyNumber(n));
    }

    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
                if (dp[i] == dp[p2] * 2) p2++;
                if (dp[i] == dp[p3] * 3) p3++;
                if (dp[i] == dp[p5] * 5) p5++;
            }
            return dp[n - 1];
        }
    }
}
