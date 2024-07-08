package leetcode.medium;

public class No1823 {

    class Solution {
        public int findTheWinner(int n, int k) {
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = (ans + k) % i;
            }
            return ans + 1;
        }
    }
}
