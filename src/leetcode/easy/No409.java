package leetcode.easy;

public class No409 {

    class Solution {
        public int longestPalindrome(String s) {
            char[] arr = s.toCharArray();
            int[] cache = new int[128];
            for (char c : arr) {
                ++cache[c];
            }
            int ans = 0;
            boolean isOdd = false;
            for (int count : cache) {
                if ((count & 1) == 1 && isOdd) {
                    ans += count - 1;
                } else if ((count & 1) == 1 && !isOdd) {
                    ans += count;
                    isOdd = true;
                } else {
                    ans += count;
                }
            }
            return ans;
        }
    }
}
