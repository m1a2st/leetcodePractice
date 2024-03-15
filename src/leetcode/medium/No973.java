package leetcode.medium;

import java.util.PriorityQueue;

/**
 * @Author m1a2st
 * @Date 2023/7/21
 * @Version v1.0
 */
public class No973 {

    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int[][] ans = new int[k][2];
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> squareDist(b) - squareDist(a));

            for (int[] point : points) {
                maxHeap.offer(point);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }

            int i = k;
            while (!maxHeap.isEmpty())
                ans[--i] = maxHeap.poll();

            return ans;
        }

        private int squareDist(int[] p) {
            return p[0] * p[0] + p[1] * p[1];
        }
    }

    class SolutionOld {
        public int[][] kClosest(int[][] points, int k) {
            int[][] ans = new int[k][2];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> squareDist(b) - squareDist(a));
            for (int[] point : points) {
                pq.offer(point);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int i = k;
            while (!pq.isEmpty()) {
                ans[--i] = pq.poll();
            }
            return ans;
        }

        private int squareDist(int[] p) {
            return p[0] * p[0] + p[1] * p[1];
        }
    }
}
