package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1043 {

    @Test
    public void test1() {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(new Solution().maxSumAfterPartitioning(arr, k));
    }

    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int max = 0;
                for (int j = 1; j <= k && i - j >= 0; j++) {
                    max = Math.max(max, arr[i - j]);
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                }
            }
            return dp[n];
        }
    }
}
