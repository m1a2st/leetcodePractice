package practice.leetcode.easy;

public class No2373 {

    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int len = grid.length;
            int[][] ans = new int[len - 2][len - 2];

            for (int i = 0; i < len - 2; ++i) {
                for (int j = 0; j < len - 2; ++j) {
                    for (int x = i; x < i + 3; ++x) {
                        for (int y = j; y < j + 3; ++y) {
                            ans[i][j] = Math.max(ans[i][j], grid[x][y]);
                        }
                    }
                }
            }

            return ans;
        }
    }
}
