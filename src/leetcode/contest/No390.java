package leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.*;

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
        int res = solution.minOperations(11);
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
        int[] nums = {2 ,3, 2, 1};
        int[] freq = {3, 2, -3, 1};
        long[] res = solution.mostFrequentIDs(nums, freq);
        System.out.println(Arrays.toString(res));
    }

    class Solution100258 {
        public static long[] mostFrequentIDs(int[] nums, int[] freq) {
            Map<Integer, Integer> count = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int n = nums.length;
            long[] ans = new long[n];

            for (int i = 0; i < n; i++) {
                count.merge(nums[i], freq[i], Integer::sum);
                pq.clear();
                pq.addAll(count.values());
                ans[i] = pq.isEmpty() ? 0 : pq.peek();
            }

            return ans;
        }
    }
}
