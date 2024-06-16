package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No857 {

    @Test
    public void test() {
        new Solution().mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);
    }

    class Solution {
        public double mincostToHireWorkers(int[] qualities, int[] wages, int k) {
            double ans = Double.MAX_VALUE;
            int qualitySum = 0;
            // (wagePerQuality, quality) sorted by wagePerQuality
            Worker[] workers = new Worker[qualities.length];
            Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < qualities.length; ++i) {
                workers[i] = new Worker(qualities[i], wages[i]);
            }

            // Greedy: try to minimize wagePerQuality
            Arrays.sort(workers, Comparator.comparingDouble(a -> a.ratio));

            for (Worker worker : workers) {
                double wagePerQuality = worker.ratio;
                int quality = worker.quality;
                // quality is the smallest among the top k qualities
                maxHeap.offer(quality);
                qualitySum += quality;
                if (maxHeap.size() > k) {
                    qualitySum -= maxHeap.poll();
                }
                // the smallest wagePerQuality among the top k qualities
                if (maxHeap.size() == k) {
                    ans = Math.min(ans, qualitySum * wagePerQuality);
                }
            }

            return ans;
        }

        public class Worker {
            int quality;
            double ratio;

            public Worker(int quality, int wage) {
                this.quality = quality;
                this.ratio = (double) wage / quality;
            }
        }
    }
}
