package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author m1a2st
 * @Date 2023/7/21
 * @Version v1.0
 */
public class No973 {

    @Test
    public void test() {
        new Solution().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    }

    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int[][] ans = new int[k][2];
            PriorityQueue<Pair> pq = new PriorityQueue<>((s1, s2) -> s2.distance - s1.distance);
            for (int[] point : points) {
                int distance = calculateDistance(point);
                pq.offer(new Pair(distance, point));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll().point;
            }
            return ans;
        }

        private int calculateDistance(int[] point) {
            return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
        }

        class Pair {
            int distance;
            int[] point;

            public Pair(int distance, int[] point) {
                this.distance = distance;
                this.point = point;
            }
        }
    }

    class SolutionP {
        public int[][] kClosest(int[][] points, int k) {
            Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
            return Arrays.copyOfRange(points, 0, k);
        }
    }
}
