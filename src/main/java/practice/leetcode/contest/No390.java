package practice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No390 {

    @Test
    public void test() {
        Solution100245 solution = new Solution100245();
        int res = solution.maximumLengthSubstring("bcbbbcba");
        System.out.println(res);
    }

    class Solution100245 {
        public int maximumLengthSubstring(String s) {
            char[] charArray = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int right = 0;
            for (char c : charArray) {
                map.merge(c, 1, Integer::sum);
                while (map.get(c) > 2) {
                    map.merge(charArray[right], -1, Integer::sum);
                    if (map.get(charArray[right]) == 0) {
                        map.remove(charArray[right]);
                    }
                    right++;
                }
                int sum = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    sum += entry.getValue();
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    @Test
    public void test2() {
        Solution100228 solution = new Solution100228();
        int res = Solution100228.minOperations(11);
        System.out.println(res);
    }

    class Solution100228 {
        public static int minOperations(int k) {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                int plusStep = k % i == 0 ? k / i - 1 : k / i;
                int sum = plusStep + i - 1;
                ans = Math.min(ans, sum);
            }
            return ans;
        }
    }

    @Test
    public void test3() {
        Solution100258 solution = new Solution100258();
        int[] nums = {5, 3, 9, 4, 3, 9, 4};
        int[] freq = {2, 4, 5, 2, -2, -4, 5};
        long[] res = solution.mostFrequentIDs(nums, freq);
        System.out.println(Arrays.toString(res));
    }

    class Solution100258 {
        public long[] mostFrequentIDs(int[] nums, int[] freq) {
            Map<Integer, Long> count = new HashMap<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> -p.freq));
            int n = nums.length;
            long[] ans = new long[n];

            for (int i = 0; i < n; i++) {
                count.merge(nums[i], (long) freq[i], Long::sum);
                pq.add(new Pair(nums[i], count.get(nums[i])));
                while (pq.peek().freq != count.get(pq.peek().id)) {
                    pq.poll();
                }
                ans[i] = pq.peek().freq < 0 ? 0 : pq.peek().freq;
            }

            return ans;
        }

        class Pair {
            int id;
            long freq;

            public Pair(int id, long freq) {
                this.id = id;
                this.freq = freq;
            }
        }
    }
}
