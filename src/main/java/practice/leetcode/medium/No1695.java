package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No1695 {

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int ans = 0;
            int score = 0;
            Set<Integer> seen = new HashSet<>();

            for (int l = 0, r = 0; r < nums.length; ++r) {
                while (!seen.add(nums[r])) {
                    score -= nums[l];
                    seen.remove(nums[l++]);
                }
                score += nums[r];
                ans = Math.max(ans, score);
            }

            return ans;
        }
    }
}
