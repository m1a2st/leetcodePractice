package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1052 {

    @Test
    public void test() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(new Solution().maxSatisfied(customers, grumpy, minutes));
    }

    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int len = customers.length;
            int satisfied = 0;
            for (int i = 0; i < len; i++) {
                if (grumpy[i] == 0) {
                    satisfied += customers[i];
                }
            }
            int sum = 0;
            for (int i = 0; i < minutes; i++) {
                sum += customers[i] * grumpy[i];
            }
            int max = sum;
            for (int i = minutes; i < len; i++) {
                sum += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
                max = Math.max(max, sum);
            }
            return satisfied + max;
        }
    }
}
