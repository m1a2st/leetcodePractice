package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No1481 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
    }

    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i : arr) {
                cache.merge(i, 1, Integer::sum);
            }
            cache.forEach((key, v) -> queue.offer(v));
            while (k > 0 && !queue.isEmpty()) {
                Integer freq = queue.poll();
                if (freq <= k) {
                    k -= freq;
                } else {
                    queue.offer(freq);
                    break;
                }
            }
            return queue.size();
        }
    }
}
