package practice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No1268 {

    @Test
    public void test() {
        int[][] grid = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(new Solution().minFallingPathSum(grid));
    }

    class Solution {
        public int minFallingPathSum(int[][] grid) {
            final int n = grid.length;
            for (int i = 1; i < n; ++i) {
                Pair[] twoMinimumAndIndexes = getTwoMinimumAndIndexes(grid[i - 1]);
                int firstMinNum = twoMinimumAndIndexes[0].key;
                int firstMinIndex = twoMinimumAndIndexes[0].value;
                int secondMinNum = twoMinimumAndIndexes[1].key;
                for (int j = 0; j < n; ++j) {
                    if (j == firstMinIndex)
                        grid[i][j] += secondMinNum;
                    else
                        grid[i][j] += firstMinNum;
                }
            }

            return Arrays.stream(grid[n - 1]).min().getAsInt();
        }

        private Pair[] getTwoMinimumAndIndexes(int[] A) {
            List<Pair> numAndIndexes = new ArrayList<>();

            for (int i = 0; i < A.length; ++i) {
                numAndIndexes.add(new Pair(A[i], i));
            }

            numAndIndexes.sort(Comparator.comparingInt(a -> a.key));
            return new Pair[]{numAndIndexes.get(0), numAndIndexes.get(1)};
        }

        class Pair {
            int key;
            int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
