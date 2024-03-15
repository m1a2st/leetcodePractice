package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;


public class No139 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int length = s.length();
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;

            for (int i = 1; i <= length; i++) {
                for (String word : wordDict) {
                    int len = word.length();
                    if (len <= i && word.equals(s.substring(i - len, i))) {
                        dp[i] = dp[i] || dp[i - len];
                    }
                }
            }
            return dp[length];
        }
    }
}
