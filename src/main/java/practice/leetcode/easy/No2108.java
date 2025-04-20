package practice.leetcode.easy;

public class No2108 {

    class Solution {
        public String firstPalindrome(String[] words) {
            for (String word : words) {
                if (isPalindromic(word)) {
                    return word;
                }
            }
            return "";
        }

        public boolean isPalindromic(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                ++left;
                --right;
            }
            return true;
        }
    }
}
