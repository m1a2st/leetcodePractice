package leecode.medium;

/**
 * @Author m1a2st
 * @Date 2023/8/20
 * @Version v1.0
 */
public class No647 {

    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;

            for (int i = 0; i < s.length(); i++) {
                ans += extendPalindromes(s, i, i);
                ans += extendPalindromes(s, i, i + 1);
            }

            return ans;
        }

        private int extendPalindromes(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            return count;
        }
    }
}
