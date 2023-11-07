package leecode.medium;

import org.junit.Test;

import java.util.Arrays;

public class No1011 {

    // give me a test
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int ans = solution.shipWithinDays(weights, days);
        System.out.println(ans);
    }

    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 0;
            for (int weight : weights) {
                right += weight;
                left = Math.max(left, weight);
            }
            int ans = right;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (canPackage(weights, days, mid)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

        private boolean canPackage(int[] weights, int days, int capacity) {
            int currentLoad = 0;
            for (int weight : weights) {
                if (currentLoad + weight > capacity) {
                    --days;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }
            return days > 0;
        }
    }

    class SolutionNew {
        public int shipWithinDays(int[] weights, int days) {
            int lo = -1, sum = 0;
            for (int w : weights) {
                sum += w;
                lo = Math.max(lo, w);
            }
            int hi = lo * (weights.length / days + Integer.signum(weights.length % days));
            lo = Math.max(lo, sum / days);
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (isOK(mid, weights, days)) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }

        private boolean isOK(int guess, int[] arr, int d) {
            int sum = 0;
            for (int n : arr) {
                if (sum + n > guess) {
                    sum = 0;
                    d--;
                }
                sum += n;
            }
            return d > 0;
        }
    }
}
