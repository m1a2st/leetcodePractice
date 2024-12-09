package main.java.parctice.leetcode.medium;

public class No1605 {

    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            final int m = rowSum.length;
            final int n = colSum.length;
            int[][] res = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    res[i][j] = Math.min(rowSum[i], colSum[j]);
                    rowSum[i] -= res[i][j];
                    colSum[j] -= res[i][j];
                }
            }
            return res;
        }
    }
}
