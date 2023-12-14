package leecode.medium;

public class No2482 {

    class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[] oneN = new int[n];
            int[] oneM = new int[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        oneN[i] += 1;
                        oneM[j] += 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = 2 * (oneN[i] + oneM[j]) - n - m;
                }
            }
            return grid;
        }
    }
}
