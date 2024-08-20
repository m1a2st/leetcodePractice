package leetcode.medium;

import java.util.Arrays;

public class No1140 {

    class Solution {
        public int stoneGameII(int[] piles) {
            final int n = piles.length;
            int[][] mem = new int[n][n];
            int[] suffix = new int[n]; // suffix[i] := sum(piles[i..n))
            Arrays.stream(mem).forEach(A -> Arrays.fill(A, -1));
            suffix[n - 1] = piles[n - 1];
            for (int i = n - 2; i >= 0; --i)
                suffix[i] = suffix[i + 1] + piles[i];
            return stoneGameII(suffix, 0, 1, mem);
        }

        // Returns the maximum number of stones Alice can get from piles[i..n) with m.
        private int stoneGameII(int[] suffix, int i, int m, int[][] mem) {
            if (i + 2 * m >= suffix.length)
                return suffix[i];
            if (mem[i][m] != -1)
                return mem[i][m];

            int opponent = suffix[i];

            for (int X = 1; X <= 2 * m; ++X)
                opponent = Math.min(opponent, stoneGameII(suffix, i + X, Math.max(m, X), mem));

            return mem[i][m] = suffix[i] - opponent;
        }
    }
}
