package leetcode.easy;

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
