package leecode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class No9Test {

    @Test
    void isPalindrome() {
        No9 no9 = new No9();
        boolean palindrome = no9.isPalindrome(121);
        assertTrue(palindrome);
    }


}