package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/11
 * @Version v1.0
 */
public class No746 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] cost = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            final int n = cost.length;

            for (int i = 2; i < n; ++i) {
                cost[i] += Math.min(cost[i - 1], cost[i - 2]);
            }

            return Math.min(cost[n - 1], cost[n - 2]);
        }
    }
}
