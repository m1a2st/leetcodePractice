package main.java.parctice.leetcode.easy;

public class No1822 {

    class Solution {
        public int arraySign(int[] nums) {
            boolean isPositive = true;
            for (int num : nums) {
                if (num < 0) {
                    isPositive = !isPositive;
                } else if (num == 0) {
                    return 0;
                }
            }
            return isPositive ? 1 : -1;
        }
    }
}
