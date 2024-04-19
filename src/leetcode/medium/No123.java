package leetcode.medium;

import org.junit.Test;

public class No123 {


    @Test
    public void test() {
        new Solution().maxProfit(new int[]{3, 2, 6, 5, 0, 3});
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int sellTwo = 0;
            int holdTwo = Integer.MIN_VALUE;
            int sellOne = 0;
            int holdOne = Integer.MIN_VALUE;

            for (int price : prices) {
                sellTwo = Math.max(sellTwo, holdTwo + price);
                holdTwo = Math.max(holdTwo, sellOne - price);
                sellOne = Math.max(sellOne, holdOne + price);
                holdOne = Math.max(holdOne, -price);
            }

            return sellTwo;
        }
    }
}
