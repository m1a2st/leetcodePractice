package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No496 {

    @Test
    public void test() {
        new Solution().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int num1 = nums1[i];
                result[i] = -1;
                boolean found = false;
                for (int k : nums2) {
                    if (num1 == k) {
                        found = true;
                    }
                    if (found) {
                        if (num1 < k) {
                            result[i] = k;
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}
