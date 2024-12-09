package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No2370 {

    @Test
    public void test() {
        System.out.println(new Solution().longestIdealString("pvjcci", 4));
    }

    class Solution {
        public int longestIdealString(String s, int k) {
            int[] dp = new int[26];

            for (char c : s.toCharArray()) {
                int i = c - 'a';
                dp[i] = 1 + getMaxReachable(dp, i, k);
            }

            return Arrays.stream(dp).max().getAsInt();
        }

        private int getMaxReachable(int[] dp, int i, int k) {
            final int first = Math.max(0, i - k);
            final int last = Math.min(25, i + k);
            int maxReachable = 0;
            for (int j = first; j <= last; ++j) {
                maxReachable = Math.max(maxReachable, dp[j]);
            }
            return maxReachable;
        }
    }
}
