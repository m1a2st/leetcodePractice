package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1545 {
    
    @Test
    public void test_findKthBit() {
        Solution s = new Solution();
        System.out.println(s.findKthBit(3, 1)); // 0
        System.out.println(s.findKthBit(4, 11)); // 1
        System.out.println(s.findKthBit(1, 1)); // 0
    }

    class Solution {
        public char findKthBit(int n, int k) {
            if (n == 1)
                return '0';
            final int midIndex = (int) Math.pow(2, n - 1); // 1-indexed
            if (k == midIndex)
                return '1';
            if (k < midIndex)
                return findKthBit(n - 1, k);
            return findKthBit(n - 1, midIndex * 2 - k) == '0' ? '1' : '0';
        }
    }
}
