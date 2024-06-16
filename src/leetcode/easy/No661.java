package leetcode.easy;

import org.junit.jupiter.api.Test;

public class No661 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] img = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] ans = solution.imageSmoother(img);
        for (int[] row : ans) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    class Solution {

        public int[][] imageSmoother(int[][] img) {
            int n = img.length;
            int m = img[0].length;
            int[][] ans = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans[i][j] = getAverage(img, i, j);
                }
            }
            return ans;
        }

        private int getAverage(int[][] img, int i, int j) {
            int nl = img.length;
            int ml = img[0].length;
            int sum = 0;
            int counter = 0;
            for (int n = Math.max(i - 1, 0); n < Math.min(i + 2, nl); n++) {
                for (int m = Math.max(j - 1, 0); m < Math.min(j + 2, ml); m++) {
                    sum += img[n][m];
                    counter++;
                }
            }
            return sum / counter;
        }
    }
}
