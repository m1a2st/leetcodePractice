package leetcode.medium;

import java.util.Arrays;

public class No1508 {

    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            int mod = 1_000_000_007;
            int[] sum = new int[n * (n + 1) / 2];
            int index = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = i; j < n; j++) {
                    temp += nums[j];
                    sum[index++] = temp;
                }
            }
            Arrays.sort(sum);
            int result = 0;
            for (int i = left - 1; i < right; i++) {
                result = (result + sum[i]) % mod;
            }
            return result;
        }
    }
}
