package parctice.leetcode.easy;

public class No2022 {

    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            if (m * n != original.length)
                return new int[0][];
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++)
                System.arraycopy(original, i * n, ans[i], 0, n);
            return ans;
        }
    }
}
