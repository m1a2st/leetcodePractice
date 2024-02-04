package leecode.hard;

import org.junit.jupiter.api.Test;

public class No76 {

    @Test
    public void test1() {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println(result);
    }

    class SolutionNew {
        public String minWindow(String s, String t) {
            int[] counter = new int[128];
            int required = t.length();
            int bestLeft = -1;
            int minLength = s.length() + 1;
            for (char c : t.toCharArray()) {
                ++counter[c];
            }
            for (int l = 0, r = 0; r < s.length(); r++) {
                if (--counter[s.charAt(r)] >= 0) {
                    --required;
                }
                while (required == 0) {
                    if (r - l + 1 < minLength) {
                        bestLeft = l;
                        minLength = r - l + 1;
                    }
                    if (++counter[s.charAt(l)] > 0) {
                        ++required;
                    }
                    ++l;
                }
            }
            return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
        }
    }

    class Solution {
        public String minWindow(String s, String t) {
            int[] count = new int[128];
            int required = t.length();
            int bestLeft = -1;
            int minLength = s.length() + 1;

            for (final char c : t.toCharArray())
                ++count[c];

            for (int l = 0, r = 0; r < s.length(); ++r) {
                if (--count[s.charAt(r)] >= 0)
                    --required;
                while (required == 0) {
                    if (r - l + 1 < minLength) {
                        bestLeft = l;
                        minLength = r - l + 1;
                    }
                    if (++count[s.charAt(l++)] > 0)
                        ++required;
                }
            }

            return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
        }
    }
}
