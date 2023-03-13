package leecode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No347 {

    public static void main(String[] args) {

    }

    static class Solution {
        public static int[] topKFrequent(int[] nums, int k) {
            int[] res = new int[k];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
            for (Integer integer : map.keySet()) {
                pq.add(integer);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = pq.poll();
            }
            return res;
        }
    }
}
