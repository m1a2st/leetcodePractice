package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1704 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.halvesAreAlike("textbook"));
    }

    class Solution {
        public boolean halvesAreAlike(String s) {
            int half = s.length() / 2;
            int aCount = 0, bCount = 0;

            for (int i = 0; i < half; i++) {
                if (isVowel(s.charAt(i))) {
                    aCount++;
                }
                if (isVowel(s.charAt(i + half))) {
                    bCount++;
                }
            }
            return aCount == bCount;
        }

        private boolean isVowel(char c) {
            return "aeiouAEIOU".indexOf(c) != -1;
        }
    }
}
