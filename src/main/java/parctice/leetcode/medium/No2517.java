package parctice.leetcode.medium;

import java.util.Arrays;

/**
 * @Author m1a2st
 * @Date 2023/4/8
 * @Version v1.0
 */
public class No2517 {

    public static void main(String[] args) {
        Solution.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3);
    }

    static class Solution {
        public static int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int left = 0;
            int right = Arrays.stream(price).max().getAsInt();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (helper(mid, price, k)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }

        private static boolean helper(int target, int[] price, int k) {
            int prev = price[0];
            int count = 1;
            for (int i = 1; i < price.length; i++) {
                if (price[i] - prev >= target) {
                    count++;
                    prev = price[i];
                }
                if (count == k) {
                    return true;
                }
            }
            return false;
        }
    }
}

