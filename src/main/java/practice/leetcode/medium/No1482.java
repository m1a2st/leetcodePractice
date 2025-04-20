package practice.leetcode.medium;

public class No1482 {

    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int len = bloomDay.length;
            if (m * k > len) {
                return -1;
            }
            int low = 1, high = 1;
            for (int day : bloomDay) {
                high = Math.max(day, high);
            }
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (canMake(bloomDay, mid, m, k)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (canMake(bloomDay, low, m, k)) {
                return low;
            } else {
                return -1;
            }
        }

        private boolean canMake(int[] bloomDay, int days, int m, int k) {
            int bouquets = 0;
            int flowers = 0;
            int len = bloomDay.length;
            for (int i = 0; i < len && bouquets < m; i++) {
                if (bloomDay[i] <= days) {
                    if (++flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            return bouquets == m;
        }
    }
}
