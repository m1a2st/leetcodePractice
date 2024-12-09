package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/11
 * @Version v1.0
 */
public class No567 {

    class SolutionP {
        public boolean checkInclusion(String s1, String s2) {
            int[] cache = new int[26];
            for (char c : s1.toCharArray()) {
                cache[c - 'a']++;
            }
            int required = s1.length();
            for (int left = 0, right = 0; right < s2.length(); ++right) {
                if (cache[s2.charAt(right) - 'a']-- > 0) {
                    required--;
                }
                while (required == 0) {
                    if (right - left + 1 == s1.length()) {
                        return true;
                    }
                    if (++cache[s2.charAt(left++) - 'a'] > 0) {
                        required++;
                    }
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] count = new int[26];
            int required = s1.length();

            // 將所有欲比對的字串加入window
            for (final char c : s1.toCharArray())
                ++count[c - 'a'];

            for (int l = 0, r = 0; r < s2.length(); ++r) {
                if (--count[s2.charAt(r) - 'a'] >= 0)
                    --required;
                while (required == 0) {
                    // 判斷字元是否連續，若是連續的為true
                    if (r - l + 1 == s1.length())
                        return true;
                    // 把原先過濾的字元回填回去，若回填的字母釋出現在s1的那麼此字母就會大於0
                    if (++count[s2.charAt(l++) - 'a'] > 0)
                        //所以s1長度要加回去
                        ++required;
                }
            }

            return false;
        }
    }
}
