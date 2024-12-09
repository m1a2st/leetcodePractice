package main.java.parctice.leetcode.medium;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No1109 {

    public static void main(String[] args) {
        Solution.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    static class Solution {
        public static int[] corpFlightBookings(int[][] bookings, int n) {
            int[] res = new int[n];
            for (int[] booking : bookings) {
                int first = booking[0];
                int last = booking[1];
                int seats = booking[2];
                res[first - 1] += seats;
                if (last < n) {
                    res[last] -= seats;
                }
            }
            for (int i = 1; i < n; i++) {
                res[i] += res[i - 1];
            }

            return res;
        }
    }
}
