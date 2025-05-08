package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No3342 {

    class Solution {
        public int minTimeToReach(int[][] moveTime) {
            return dijkstra(moveTime, new int[]{0, 0}, new int[]{moveTime.length - 1, moveTime[0].length - 1});
        }

        private int dijkstra(int[][] moveTime, int[] src, int[] dst) {
            final int[][] kDirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            final int m = moveTime.length;
            final int n = moveTime[0].length;

            int[][] dist = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = 0;

            // 使用優先佇列 (d, (ux, uy))
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            minHeap.offer(new int[]{dist[0][0], src[0], src[1]});

            while (!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int d = current[0];
                int i = current[1];
                int j = current[2];

                if (i == dst[0] && j == dst[1]) {
                    return d;
                }

                if (d > dist[i][j]) {
                    continue;
                }

                for (int[] dir : kDirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < 0 || x == m || y < 0 || y == n) {
                        continue;
                    }

                    int newDist = Math.max(moveTime[x][y], d) + ((i + j) % 2 + 1);
                    if (newDist < dist[x][y]) {
                        dist[x][y] = newDist;
                        minHeap.offer(new int[]{newDist, x, y});
                    }
                }
            }

            return -1;
        }
    }
}
