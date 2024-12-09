package parctice.leetcode.easy;

import java.util.Arrays;

public class No2706 {

    class Solution {
        public int buyChoco(int[] prices, int money) {
            Arrays.sort(prices);
            int p1 = prices[0];
            int p2 = prices[1];
            int ans = money - p1 - p2;
            return ans >= 0 ? ans : money;
        }
    }


    class SolutionNew {
        public int buyChoco(int[] prices, int money) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (final int price : prices) {
                if (price <= min1) {
                    min2 = min1;
                    min1 = price;
                } else if (price < min2) {
                    min2 = price;
                }
            }

            final int minCost = min1 + min2;
            return minCost > money ? money : money - minCost;
        }
    }
}
