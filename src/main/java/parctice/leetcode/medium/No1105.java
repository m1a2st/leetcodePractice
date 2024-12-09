package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No1105 {
    
    @Test
    public void test() {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        System.out.println(new Solution().minHeightShelves(books, shelfWidth));
    }

    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            final int n = books.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < books.length; ++i) {
                int sumThickness = 0;
                int maxHeight = 0;
                for (int j = i; j >= 0; --j) {
                    int thickness = books[j][0];
                    int height = books[j][1];
                    sumThickness += thickness;
                    if (sumThickness > shelfWidth)
                        break;
                    maxHeight = Math.max(maxHeight, height);
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
                }
            }

            return dp[n];
        }
    }
}
