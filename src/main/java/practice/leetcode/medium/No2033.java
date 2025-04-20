package practice.leetcode.medium;

import java.util.Arrays;

public class No2033 {

    class Solution {
        public int minOperations(int[][] grid, int x) {
            final int m = grid.length;
            final int n = grid[0].length;
            int[] arr = new int[m * n];
            for (int i = 0; i < m; ++i)
                System.arraycopy(grid[i], 0, arr, i * n, n);
            if (Arrays.stream(arr).anyMatch(a -> (a - arr[0]) % x != 0))
                return -1;

            int ans = 0;

            Arrays.sort(arr);

            for (final int a : arr)
                ans += Math.abs(a - arr[arr.length / 2]) / x;

            return ans;
        }
    }
}
