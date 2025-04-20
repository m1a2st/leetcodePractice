package practice.leetcode.medium;

import java.util.Arrays;

public class No45 {


    class Solution {
        public int jump(int[] nums) {
            int ans = 0;
            int end = 0;
            int farthest = 0;
            int len = nums.length - 1;

            // Implicit BFS
            for (int i = 0; i < len; ++i) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= len) {
                    ++ans;
                    break;
                }
                if (i == end) {   // Visited all the items on the current level.
                    ++ans;          // Increment the level.
                    end = farthest; // Make the queue size for the next level.
                }
            }

            return ans;
        }
    }

    class SolutionNew {
        public int jump(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < len; ++i) {
                for (int j = 1; j <= nums[i]; ++j) {
                    if (i + j < len) {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
            return dp[len - 1];
        }
    }
}
