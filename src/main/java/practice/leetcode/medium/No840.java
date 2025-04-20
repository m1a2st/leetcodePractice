package practice.leetcode.medium;

public class No840 {

    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int ans = 0;
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[0].length - 1; j++) {
                    if (grid[i][j] == 5 && isMagic(grid, i, j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean isMagic(int[][] grid, int i, int j) {
            int[] count = new int[16];
            for (int x = i - 1; x <= i + 1; x++) {
                for (int y = j - 1; y <= j + 1; y++) {
                    count[grid[x][y]]++;
                }
            }
            for (int k = 1; k <= 9; k++) {
                if (count[k] != 1) {
                    return false;
                }
            }
            return grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15
                    && grid[i][j - 1] + grid[i][j] + grid[i][j + 1] == 15
                    && grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15
                    && grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15
                    && grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == 15
                    && grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15
                    && grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1] == 15
                    && grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] == 15;
        }
    }
}
