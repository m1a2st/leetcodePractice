package leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1903 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("52"));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("13579")); // Expected output: "13579"
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("24680")); // Expected output: ""
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("9876543210")); // Expected output: "987654321"
    }

    class Solution {
        public String largestOddNumber(String num) {
            for (int length = num.length() - 1; length >= 0; length--) {
                char c = num.charAt(length);
                if (c % 2 == 1) {
                    return num.substring(0, length + 1);
                }
            }
            return "";
        }
    }
}
