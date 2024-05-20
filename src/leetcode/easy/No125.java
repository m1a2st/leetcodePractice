package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/6
 * @Version v1.0
 */
public class No125 {

    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || "".equals(s)) return true;
            String l = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int left = 0, right = l.length() - 1;
            while (left < right) {
                if (l.charAt(left) == l.charAt(right)) {
                    left++;
                    right--;
                } else {
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
