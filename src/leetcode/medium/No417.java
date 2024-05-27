package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/5
 * @Version v1.0
 */
public class No417 {

    @Test
    public void test() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(heights));
    }

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            final int m = heights.length;
            final int n = heights[0].length;
            List<List<Integer>> ans = new ArrayList<>();
            boolean[][] seenP = new boolean[m][n];
            boolean[][] seenA = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                dfs(heights, i, 0, 0, seenP);
                dfs(heights, i, n - 1, 0, seenA);
            }

            for (int j = 0; j < n; ++j) {
                dfs(heights, 0, j, 0, seenP);
                dfs(heights, m - 1, j, 0, seenA);
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (seenP[i][j] && seenA[i][j]) {
                        ans.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }

            return ans;
        }

        private void dfs(final int[][] heights, int i, int j, int h, boolean[][] seen) {
            if (i < 0 || i == heights.length || j < 0 || j == heights[0].length) {
                return;
            }
            if (seen[i][j] || heights[i][j] < h) {
                return;
            }

            seen[i][j] = true;
            dfs(heights, i + 1, j, heights[i][j], seen);
            dfs(heights, i - 1, j, heights[i][j], seen);
            dfs(heights, i, j + 1, heights[i][j], seen);
            dfs(heights, i, j - 1, heights[i][j], seen);
        }
    }
}
