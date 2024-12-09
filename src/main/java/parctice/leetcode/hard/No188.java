package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

public class No188 {

    @Test
    public void test() {
        new Solution().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
    }

    class Solution {
        public int maxProfit(int k, int[] prices) {
            int[] dp = new int[k * 2];
            for (int i = 0; i < dp.length; i++) {
                if ((i & 1) == 0) {
                    dp[i] = Integer.MIN_VALUE;
                }
            }
            for (int price : prices) {
                for (int i = dp.length - 1; i > 0; i--) {
                    if ((i & 1) == 0) {
                        dp[i] = Math.max(dp[i], dp[i - 1] - price);
                    } else {
                        dp[i] = Math.max(dp[i], dp[i - 1] + price);
                    }
                }
                dp[0] = Math.max(dp[0], -price);
            }
            return dp[k * 2 - 1];
        }
    }
}
