package leetcode.medium;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/4
 * @Version v1.0
 */
public class No695 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1, 1, 0, 0, 0},
                                   {1, 1, 0, 0, 0},
                                   {0, 0, 1, 1, 1},
                                   {0, 0, 0, 1, 1}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    class Solution {

        int ans = 0;
        int count = 0;

        public int maxAreaOfIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                        if (count > ans) {
                            ans = count;
                        }
                        count = 0;
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return;

            grid[i][j] = 0;
            count++;

            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }
}
