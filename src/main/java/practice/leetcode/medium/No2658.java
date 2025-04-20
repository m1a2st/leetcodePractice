package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class No2658 {

    class Solution {
        private static final int[] dr = {-1, 0, 1, 0};
        private static final int[] dc = {0, 1, 0, -1};

        public int findMaxFish(int[][] grid) {
            boolean[][] visited = new boolean[10][10];
            int maximum = 0, totalFishes;
            int rows = grid.length, columns = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] > 0 && !visited[i][j]) {
                        Queue<Integer> qRows = new LinkedList<>();
                        Queue<Integer> qColumns = new LinkedList<>();

                        qRows.offer(i);
                        qColumns.offer(j);
                        visited[i][j] = true;
                        totalFishes = grid[i][j];

                        while (!qRows.isEmpty()) {
                            int nowRow = qRows.poll();
                            int nowColumn = qColumns.poll();

                            for (int k = 0; k < 4; k++) {
                                int newRow = nowRow + dr[k];
                                int newColumn = nowColumn + dc[k];

                                if (0 <= newRow && newRow < rows &&
                                        0 <= newColumn && newColumn < columns &&
                                        grid[newRow][newColumn] > 0 &&
                                        !visited[newRow][newColumn]) {

                                    qRows.offer(newRow);
                                    qColumns.offer(newColumn);
                                    visited[newRow][newColumn] = true;
                                    totalFishes += grid[newRow][newColumn];
                                }
                            }
                        }
                        maximum = Math.max(maximum, totalFishes);
                    }
                }
            }
            return maximum;
        }
    }
}
