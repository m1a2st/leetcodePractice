package main.java.parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

public class No992 {

    @Test
    public void test() {
        new Solution().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }

    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int[] numFreq = new int[nums.length + 1];
            int distinct = 0, left = 0, right = 0, ans = 0;
            while (distinct == k || right < nums.length) {
                while (distinct < k && right < nums.length) {
                    if (numFreq[nums[right]] == 0) {
                        distinct++;
                    }
                    numFreq[nums[right]]++;
                    right++;
                }
                int maxEnd = right;
                while (maxEnd < nums.length && numFreq[nums[maxEnd]] > 0) {
                    maxEnd++;
                }
                while (distinct == k) {
                    if (numFreq[nums[left]] == 1) {
                        distinct--;
                    }
                    numFreq[nums[left]]--;
                    left++;
                    ans += (maxEnd - right + 1);
                }
            }
            return ans;
        }
    }
}
