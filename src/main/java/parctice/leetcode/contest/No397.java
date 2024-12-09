package main.java.parctice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No397 {

    class Solution100296 {
        public int findPermutationDifference(String s, String t) {
            Map<Character, Integer> cache = new HashMap<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                cache.put(array[i], i);
            }
            char[] tArr = t.toCharArray();
            int ans = 0;
            for (int i = 0; i < tArr.length; i++) {
                if (cache.containsKey(tArr[i])) {
                    ans += Math.abs(cache.get(tArr[i]) - i);
                }
            }

            return ans;
        }
    }

    @Test
    public void test() {
        new Solution100274().maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3);
    }

    class Solution100274 {
        public int maximumEnergy(int[] energy, int k) {
            int[] temp = new int[energy.length];
            for (int i = 0; i < energy.length; i++) {
                if (i < k) {
                    for (int j = i; j < energy.length; j += k) {
                        temp[i] += energy[j];
                    }
                } else {
                    temp[i] = temp[i - k] - energy[i - k];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i : temp) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
    }

    // [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
    @Test
    public void test100281() {
        List<List<Integer>> grid = List.of(
                List.of(9, 5, 7, 3),
                List.of(8, 9, 6, 1),
                List.of(6, 7, 14, 3),
                List.of(2, 5, 3, 1)
        );
        new Solution100281().maxScore(grid);
    }

    class Solution100281 {
        public int maxScore(List<List<Integer>> grid) {
            int n = grid.size();
            int m = grid.get(0).size();
            int min = Integer.MIN_VALUE;
            int[][] dp = new int[n][m];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    dp[i][j] = grid.get(i).get(j);
                    if (i < n - 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                    }
                    if (j < m - 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i < n - 1) {
                        min = Math.max(min, dp[i + 1][j] - grid.get(i).get(j));
                    }
                    if (j < m - 1) {
                        min = Math.max(min, dp[i][j + 1] - grid.get(i).get(j));
                    }
                }
            }
            return min;
        }
    }
}
