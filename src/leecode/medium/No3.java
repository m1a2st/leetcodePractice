package leecode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/3/30
 * @Version v1.0
 */
public class No3 {
    class Solution {
        public int lengthOfLongestSubstringOld(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int res = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    window.put(d, window.get(d) - 1);
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }

        public int lengthOfLongestSubstring(String s) {
            int right = 0, left = 0;
            int ans = 0;
            Map<Character, Integer> window = new HashMap<>();
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    window.put(d, window.get(d) - 1);
                }
                ans = Math.max(ans, right - left);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.lengthOfLongestSubstring(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring(s));
    }
}
