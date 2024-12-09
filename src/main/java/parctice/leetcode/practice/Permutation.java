package main.java.parctice.leetcode.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Permutation {
    public static void main(String[] args) {

    }

    public String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return String.valueOf(content);
    }

    private boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    @Test
    public void string_sort() {
        String test = "ASDFGH";
        String sort = sort(test);
        Assertions.assertEquals("ADFGHS", sort);
    }

    @Test
    public void string_compare_true() {
        String str1 = "ASDFG";
        String str2 = "GFDSA";
        boolean result = permutation(str1, str2);
        Assertions.assertTrue(result);
    }

    @Test
    public void string_compare_false() {
        String str1 = "ASDFG";
        String str2 = "GFDSAFGH";
        boolean result = permutation(str1, str2);
        Assertions.assertFalse(result);
    }


}
