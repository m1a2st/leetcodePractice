package main.java.parctice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No560 {

    public static void main(String[] args) {
        Solution.subarraySum(new int[]{1, 1, 1}, 2);
    }

    static class Solution {
        public static int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

    class SolutionNew {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int prefix = 0;
            Map<Integer, Integer> count = new HashMap<>();
            count.put(0, 1);

            for (final int num : nums) {
                prefix += num;
                ans += count.getOrDefault(prefix - k, 0);
                count.merge(prefix, 1, Integer::sum);
            }
            return ans;
        }
    }
}
