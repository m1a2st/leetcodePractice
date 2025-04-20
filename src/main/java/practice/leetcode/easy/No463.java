package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No463 {

    @Test
    public void test() {
        new Solution().islandPerimeter(new int[][]
                {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
    }

    class Solution {
        public int islandPerimeter(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        result += 4;
                        if (i > 0) {
                            if (grid[i - 1][j] == 1) {
                                result -= 2;
                            }
                        }
                        if (j > 0) {
                            if (grid[i][j - 1] == 1) {
                                result -= 2;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
