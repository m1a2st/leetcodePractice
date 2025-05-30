package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No63 {

    @Test
    public void test() {
        System.out.println(new Solution()
                .uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] != 1) {
                    dp[0][i] = 1;
                } else {
                    break;
                }
            }
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] != 1) {
                    dp[i][0] = 1;
                } else {
                    break;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
