package practice.leetcode.medium;

public class No1701 {
    
    class Solution {
        public double averageWaitingTime(int[][] customers) {
            double wait = 0;
            double curr = 0;

            for (int[] c : customers) {
                curr = Math.max(curr, 1.0 * c[0]) + c[1];
                wait += curr - c[0];
            }

            return wait / customers.length;
        }
    }
}
