package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No786 {

    @Test
    public void test() {
        new Solution().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            double left = 0, right = 1;
            while (left < right) {
                double mid = left + (right - left) / 2;
                int count = 0;
                int p = 0, q = 1;
                for (int i = 0, j = 0; i < n; i++) {
                    while (j < n && arr[i] > mid * arr[j]) {
                        j++;
                    }
                    count += n - j;
                    if (j < n && p * arr[j] < q * arr[i]) {
                        p = arr[i];
                        q = arr[j];
                    }
                }
                if (count == k) {
                    return new int[]{p, q};
                } else if (count < k) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return new int[]{};
        }
    }
}
