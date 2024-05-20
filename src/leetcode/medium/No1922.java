package leetcode.medium;

public class No1922 {

    class Solution {

        public static final int K_MOD = 1_000_000_007;

        public int countGoodNumbers(long n) {
            int[] primeNumber = new int[]{2, 3, 5, 7};
            int[] evenNumber = new int[]{0, 2, 4, 6, 8};
            int ans = 0;
            return modPow(20, n / 2) * (n % 2 == 1 ? 5 : 1) % K_MOD;
        }

        private int modPow(int x, long n) {
            if (n == 0) {
                return 1;
            }
            if (n % 2 == 1) {
                return x * modPow(x, n - 1) % K_MOD;
            } else {
                return modPow(x * x % K_MOD, n / 2);
            }
        }
    }
}
