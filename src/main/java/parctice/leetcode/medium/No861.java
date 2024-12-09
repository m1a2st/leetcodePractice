package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No861 {

    // [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    @Test
    public void test() {
        System.out.println(new Solution().matrixScore(new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        }));
    }

    class Solution {
        public int matrixScore(int[][] grid) {
            final int column = grid.length;
            final int row = grid[0].length;
            // All the cells in the first column are 1.
            int ans = column;

            for (int j = 1; j < row; ++j) {
                int onesCount = 0;
                // The best strategy is flipping the rows with a leading 0..
                for (int[] ints : grid) {
                    onesCount += ints[j] == ints[0] ? 1 : 0;
                }
                ans = ans * 2 + Math.max(onesCount, column - onesCount);
            }

            return ans;
        }
    }
}
