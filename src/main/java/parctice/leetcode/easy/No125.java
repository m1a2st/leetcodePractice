package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/6
 * @Version v1.0
 */
public class No125 {

    /**
     * 1. 先將字串轉為小寫，並過濾掉非字母和數字的字符
     * 2. 雙指針，一個指向頭，一個指向尾，比較兩個字符是否相等
     */
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) return true;
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toLowerCase().toCharArray();
            for (char c : chars) {
                if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                    sb.append(c);
                }
            }
            int left = 0, right = sb.length() - 1;
            while (left < right) {
                if (sb.charAt(left++) != sb.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }


    @Test
    public void test() {
        // write test here
        String s = "A man, a plan. a canal :Panama";
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(s);
        assertTrue(palindrome);
    }

    @Test
    public void test2() {
        // write test here
        String s = "race a car";
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(s);
        assertFalse(palindrome);
    }

}
