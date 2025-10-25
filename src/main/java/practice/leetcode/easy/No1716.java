package practice.leetcode.easy;

public class No1716 {

    class Solution {
        public int totalMoney(int n) {
            int allWeeks = n / 7;
            int lastDays = n % 7;
            int ans = 0;
            for (int i = 1; i <= allWeeks; ++i) {
                ans += ((i - 1) * 7) + 28;
            }
            for (int i = 1; i <= lastDays; ++i) {
                ans += allWeeks + i;
            }
            return ans;
        }
    }
}
