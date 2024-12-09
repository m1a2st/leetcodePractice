package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/6/8
 * @Version v1.0
 */
public class No121 {

    @Test
    public void test() {
        int[] s = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.maxProfit(s));
    }

    @Test
    public void test2() {
        int[] s = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.maxProfit(s));
    }

    /**
     * 1. 買入價格為第一天價格
     * 2. 如果買入價格大於當前價格，則更新買入價格
     * 3. 如果當前價格減去買入價格大於當前最大利潤，則更新最大利潤
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int ans = 0;
            for (int price : prices) {
                if (buy > price) {
                    buy = price;
                } else {
                    ans = Math.max(ans, price - buy);
                }
            }
            return ans;
        }
    }
}
