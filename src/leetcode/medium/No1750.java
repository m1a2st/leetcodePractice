package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1750 {

    @Test
    public void test() {
        new Solution().minimumLength("abbbbbbbbbbbbbbbbbbba");
    }

    class Solution {
        public int minimumLength(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (chars[left] != chars[right]) break;
                char sameChar = chars[left];
                while (chars[left] == sameChar && left < right) {
                    ++left;
                }
                while (chars[right] == sameChar && left <= right) {
                    --right;
                }
            }
            return right - left + 1;
        }
    }
}
