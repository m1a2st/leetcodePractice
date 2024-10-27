package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1277 {

    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.countSquares(new int[][]{
                {0, 1, 1, 1}, 
                {1, 1, 1, 1}, 
                {0, 1, 1, 1}
        }));
    }

    class Solution {
        public int countSquares(int[][] matrix) {
            final int m = matrix.length, n = matrix[0].length;
            int ans = 0;
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0)
                        continue;
                    if (i > 0 && j > 0)
                        matrix[i][j] += Math.min(matrix[i - 1][j - 1],
                                Math.min(matrix[i - 1][j],
                                        matrix[i][j - 1]));
                    ans += matrix[i][j];
                }
            return ans;
        }
    }
}
