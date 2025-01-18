package parctice.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No1368 {

    class Solution {
        public int minCost(int[][] grid) {
            final int m = grid.length;
            final int n = grid[0].length;
            int[][] mem = new int[m][n];
            Arrays.stream(mem).forEach(A -> Arrays.fill(A, -1));
            Queue<Pair> q = new ArrayDeque<>();

            dfs(grid, 0, 0, /*cost=*/0, q, mem);

            for (int cost = 1; !q.isEmpty(); ++cost)
                for (int sz = q.size(); sz > 0; --sz) {
                    Pair pair = q.poll();
                    final int i = pair.key;
                    final int j = pair.value;
                    for (int[] dir : dirs)
                        dfs(grid, i + dir[0], j + dir[1], cost, q, mem);
                }

            return mem[m - 1][n - 1];
        }

        private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        private void dfs(int[][] grid, int i, int j, int cost, Queue<Pair> q,
                         int[][] mem) {
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
                return;
            if (mem[i][j] != -1)
                return;

            mem[i][j] = cost;
            q.add(new Pair(i, j));
            int[] dir = dirs[grid[i][j] - 1];
            dfs(grid, i + dir[0], j + dir[1], cost, q, mem);
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
