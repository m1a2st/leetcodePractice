package practice.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No122 {

    @Test
    public void test() {
        int[] s = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        Assertions.assertEquals(7, solution.maxProfit(s));
    }

    @Test
    public void test2() {
        int[] s = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.maxProfit(s));
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int ans = 0;
            for (int price : prices) {
                if (price >= buy) {
                    ans += price - buy;
                }
                buy = price;
            }
            return ans;
        }
    }
}
