package main.java.parctice.leetcode.medium;

public class No1653 {

    class Solution {
        public int minimumDeletions(String s) {
            int dp = 0;
            int countB = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    dp = Math.min(dp + 1, countB);
                } else {
                    countB++;
                }
            }
            return dp;
        }
    }
}
