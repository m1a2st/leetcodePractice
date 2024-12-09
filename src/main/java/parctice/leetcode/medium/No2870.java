package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No2870 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int ans = solution.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4});
        System.out.println(ans);
    }

    class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> count = new HashMap<>();

            for (final int num : nums) {
                count.merge(num, 1, Integer::sum);
            }

            for (final int freq : count.values()) {
                if (freq == 1) {
                    return -1;
                }
                ans += (freq + 2) / 3;
            }
            return ans;
        }
    }
}
