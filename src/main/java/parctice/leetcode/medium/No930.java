package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No930 {

    @Test
    public void test() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int i = new Solution().numSubarraysWithSum(nums, goal);
    }

    class Solution {

        int sum = 0;
        int count = 0;
        int[] sums = new int[20001];

        public int numSubarraysWithSum(int[] nums, int goal) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                backTracking(nums, i, goal);
            }
            return count;
        }

        private void backTracking(int[] nums, int i, int goal) {
            if (i == nums.length) return;
            sum += nums[i];
            if (sum == goal) {
                count++;
            }
            backTracking(nums, i + 1, goal);
            sum -= nums[i];
        }
    }

    class SolutionMap {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int ans = 0;
            int prefix = 0;
            Map<Integer, Integer> count = new HashMap<>();
            count.put(0, 1);

            for (int num : nums) {
                prefix += num;
                int key = prefix - goal;
                if (count.containsKey(key)) {
                    ans += count.get(key);
                }
                count.merge(prefix, 1, Integer::sum);
            }

            return ans;
        }
    }


}
