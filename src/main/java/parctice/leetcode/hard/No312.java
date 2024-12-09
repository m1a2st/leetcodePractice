package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

public class No312 {

    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.maxCoins(new int[]{3, 1, 5, 8}));
    }

    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] newNums = new int[n + 2];
            newNums[0] = 1;
            newNums[n + 1] = 1;
            System.arraycopy(nums, 0, newNums, 1, n);
            int[][] dp = new int[n + 2][n + 2];
            // [3, 1, 5, 8 ] => [1, 3, 1, 5, 8, 1]
            for (int i = n; i >= 0; i--) {
                for (int j = i + 1; j < n + 2; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                    }
                }
            }
            return dp[0][n + 1];
        }
    }
}
