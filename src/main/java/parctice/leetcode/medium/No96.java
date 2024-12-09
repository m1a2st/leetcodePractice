package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No96 {

    @Test
    public void test() {
        new Solution().numTrees(3);
    }

    class Solution {
        public int numTrees(int n) {
            // dp[i] := the number of unique BST's that store values 1..i
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            //當 j 在內部循環中遍歷時，它代表了分割 BST 的位置，即左子樹的範圍是 [0, j-1]，而右子樹的範圍是 [j, i-1]。
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
}
