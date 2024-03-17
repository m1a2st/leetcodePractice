package leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No70 {

    class SolutionOld {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}