package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

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

    static class Solution {
        public static int[] topKFrequentOld(int[] nums, int k) {
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


        public static int[] topKFrequent(int[] nums, int k) {
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
            int[] res = new int[k];
            for (int i = 0; i < res.length; i++) {
                res[i] = pq.poll();
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = Solution.topKFrequent(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 1;
        int[] res = Solution.topKFrequent(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
