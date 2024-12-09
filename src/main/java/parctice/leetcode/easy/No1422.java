package main.java.parctice.leetcode.easy;

public class No1422 {

    class Solution {
        public int maxScore(String s) {

            int lSum = s.charAt(0) == '0' ? 1 : 0;
            int rSum = 0;

            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    rSum++;
                }
            }
            int ans = lSum + rSum;

            for (int left = 1; left < s.length() - 1; left++) {
                char c = s.charAt(left);
                if (c == '0') {
                    lSum++;
                } else {
                    rSum--;
                }

                ans = Math.max(ans, lSum + rSum);
            }
            return ans;
        }
    }
}
