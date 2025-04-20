package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1758 {

    @Test
    public void testMinOperations() {
        Solution solution = new Solution();
        assert solution.minOperations("0100") == 1;
        assert solution.minOperations("10") == 0;
        assert solution.minOperations("1111") == 2;
    }

    class Solution {
        public int minOperations(String s) {
            int firstZeroCount = 0;
            int firstOneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    if (i % 2 == 0) {
                        firstZeroCount++;
                    } else {
                        firstOneCount++;
                    }
                } else {
                    if (i % 2 == 0) {
                        firstOneCount++;
                    } else {
                        firstZeroCount++;
                    }
                }
            }
            return Math.min(firstZeroCount, firstOneCount);
        }
    }
}
