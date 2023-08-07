package leecode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author m1a2st
 * @Date 2023/8/7
 * @Version v1.0
 */
public class No994 {

    class Solution {
        public int orangesRotting(int[][] grid) {
            int x = grid.length;
            int y = grid[0].length;
            int fresh = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 1) {
                        fresh++;
                    } else if (grid[i][j] == 2) {
                        queue.add(i);
                        queue.add(j);
                    }
                }
            }
            if (fresh == 0) return 0;
            if (queue.isEmpty()) return -1;

            int time = 0;
            while (!queue.isEmpty() && fresh > 0) {
                int size = queue.size() / 2;
                for (int t = 0; t < size; t++) {
                    int i = queue.poll();
                    int j = queue.poll();

                    add(queue, grid, i + 1, j);
                    add(queue, grid, i, j + 1);
                    add(queue, grid, i - 1, j);
                    add(queue, grid, i, j - 1);
                }
                fresh -= queue.size() / 2;
                time++;
            }
            if (fresh > 0) {
                return -1;
            }
            return time;
        }

        private void add(Queue<Integer> queue, int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 2;
                queue.add(i);
                queue.add(j);
            }
        }
    }

    class SolutionTest {
        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int fresh = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        fresh++;
                    } else if (grid[i][j] == 2) {
                        queue.add(i);
                        queue.add(j);
                    }
                }
            }
            if (fresh == 0) {
                return 0;
            }
            if (queue.isEmpty()) {
                return -1;
            }
            int time = 0;
            while (!queue.isEmpty() && fresh > 0) {
                int size = queue.size() / 2;
                for (int x = 0; x < size; x++) {
                    int i = queue.poll();
                    int j = queue.poll();
                    add(queue, grid, i + 1, j);
                    add(queue, grid, i - 1, j);
                    add(queue, grid, i, j + 1);
                    add(queue, grid, i, j - 1);
                }
                fresh -= queue.size() / 2;
                time++;
            }
            if (fresh > 0) {
                return -1;
            }
            return time;
        }

        private void add(Queue<Integer> queue, int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 2;
                queue.add(i);
                queue.add(j);
            }
        }
    }
}
