package leecode.easy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

class No9Test {

    @Test
    void isPalindrome() {
        No9 no9 = new No9();
        boolean palindrome = no9.isPalindrome(121);
        assertTrue(palindrome);
    }


}