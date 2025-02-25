package parctice.leetcode.medium;

public class No1524 {
    
    class Solution {
        public int numOfSubarrays(int[] arr) {
            final int MOD = 1000000007;
            final int n = arr.length;
            int odd = 0;
            int even = 1;
            int sum = 0;
            int res = 0;

            for (int j : arr) {
                sum += j;
                if (sum % 2 == 0) {
                    res = (res + odd) % MOD;
                    ++even;
                } else {
                    res = (res + even) % MOD;
                    ++odd;
                }
            }

            return res;
        }
    }
}
