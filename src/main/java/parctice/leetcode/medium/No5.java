package parctice.leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/3/22
 * @Version v1.0
 */
public class No5 {

    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            // 空串和只有一個字符的字符串都是回文串
            if (len < 2) {
                return s;
            }
            String res = s.substring(0, 1);
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            char[] chars = s.toCharArray();
            // 枚舉最長回文串的長度
            for (int k = 2; k <= len; k++) {
                for (int i = 0; i < len; i++) {
                    int j = k + i - 1;
                    if (j >= len) {
                        break;
                    }
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                        continue;
                    }
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
    }
}
