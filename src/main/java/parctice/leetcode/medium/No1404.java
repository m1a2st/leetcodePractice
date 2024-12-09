package main.java.parctice.leetcode.medium;

public class No1404 {

    class Solution {
        /**
         * 時間複雜度：O(n)
         */
        public int numSteps(String s) {
            int res = 0, carry = 0;

            for (int i = s.length() - 1; i > 0; i--) {
                res++;
                if (s.charAt(i) - '0' + carry == 1) {
                    carry = 1;
                    res++;
                }

            }

            return res + carry;
        }
    }
}
