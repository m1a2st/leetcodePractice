package practice.leetcode.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Palindrome {

    @Test
    public void is_palindrome() {
        String str = "aabbccbbaa";
        boolean palindrome = palindrome(str);
        Assertions.assertTrue(palindrome);
    }

    @Test
    public void is__palindrome() {
        String str = "aabbcbbaa";
        boolean palindrome = palindrome(str);
        Assertions.assertTrue(palindrome);
    }

    @Test
    public void is_not_palindrome() {
        String str = "aaccbbaa";
        boolean palindrome = palindrome(str);
        Assertions.assertFalse(palindrome);
    }

    private boolean palindrome(String str) {
        boolean isPalindrome = false;
        if (str.length() == 0) return true;
        for (int i = 0; i < (str.length() / 2); i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
