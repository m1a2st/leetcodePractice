package practice.leetcode.easy;

public class No1518 {


    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = numBottles;
            int waitForExchange = numBottles;
            while (waitForExchange / numExchange > 0) {
                int canExchange = waitForExchange / numExchange;
                ans += canExchange;
                waitForExchange = waitForExchange % numExchange;
                waitForExchange += canExchange;
            }
            return ans;
        }
    }
}
