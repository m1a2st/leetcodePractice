package practice.leetcode.medium;

import java.util.Arrays;

public class No3201 {
    
    class Solution {
        public int maximumLength(int[] nums) {
            // dp[i][j] := 有效子序列的最大長度，其中最後一個
            // 數字 mod 2 等於 i，下一個期望數字 mod 2 等於 j
            int[][] dp = new int[2][2];

            // 擴展模式 xyxyxy...xy
            for (int x : nums) {
                for (int y = 0; y < 2; y++) {
                    dp[x % 2][y] = dp[y][x % 2] + 1;
                }
            }

            // 找出所有 dp 值中的最大值
            int maxLength = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }

            return maxLength;
        }
    }
}
