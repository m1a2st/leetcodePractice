package parctice.leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/8/21
 * @Version v1.0
 */
public class No91 {

    class Solution {
        public int numDecodings(String s) {
            final int n = s.length();
            // dp[i] := # of ways to decode s[i..n)
            int[] dp = new int[n + 1];
            dp[n] = 1; // ""
            dp[n - 1] = isValid(s.charAt(n - 1)) ? 1 : 0;

            for (int i = n - 2; i >= 0; --i) {
                if (isValid(s.charAt(i)))
                    dp[i] += dp[i + 1];
                if (isValid(s.charAt(i), s.charAt(i + 1)))
                    dp[i] += dp[i + 2];
            }

            return dp[0];
        }

        private boolean isValid(char c) {
            return c != '0';
        }

        private boolean isValid(char c1, char c2) {
            return c1 == '1' || c1 == '2' && c2 < '7';
        }
    }

    class SolutionNew {
        public int numDecodings(String s) {
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[len] = 1;
            dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
            for (int i = len - 2; i >= 0; --i) {
                char iChar = s.charAt(i);
                if (iChar != '0') {
                    dp[i] += dp[i + 1];
                }
                if (iChar == '1' || (iChar == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
            return dp[0];
        }
    }
}
