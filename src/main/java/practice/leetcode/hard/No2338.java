package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2338 {

    class Solution {
        private static final int MOD = 1_000_000_007;

        public int idealArrays(int n, int maxValue) {
            // 由於 2^14 > 10^4，最長的嚴格遞增數組是 [1, 2, 4, ..., 2^13]
            final int maxLength = Math.min(14, n);
            final List<List<Integer>> factors = getFactors(maxValue);

            // dp[i][j] := 長度為 i 且以 j 結尾的嚴格遞增理想數組的數量
            // dp[i][j] := sum(dp[i - 1][k]), 其中 j % k == 0
            // dp[i][0] := sum(dp[i][j]) 其中 1 <= j <= maxValue
            long[][] dp = new long[maxLength + 1][maxValue + 1];
            long[][] mem = new long[n][maxLength];

            // 初始化記憶化搜索數組
            for (int i = 0; i < n; i++) {
                Arrays.fill(mem[i], -1);
            }

            long ans = 0;

            // 初始化長度為 1 的數組
            for (int j = 1; j <= maxValue; ++j) {
                dp[1][j] = 1;
            }

            // 計算 dp 表
            for (int i = 2; i <= maxLength; ++i) {
                for (int j = 1; j <= maxValue; ++j) {
                    for (int k : factors.get(j)) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }

            // 計算 dp[i][0]，即所有長度為 i 的理想數組數量
            for (int i = 1; i <= maxLength; ++i) {
                for (int j = 1; j <= maxValue; ++j) {
                    dp[i][0] += dp[i][j];
                    dp[i][0] %= MOD;
                }
            }

            // 計算答案
            for (int i = 1; i <= maxLength; ++i) {
                // nCk(n - 1, i - 1) := 從長度為 i 的嚴格遞增數組創建長度為 n 的理想數組的方法數
                ans += dp[i][0] * nCk(n - 1, i - 1, mem);
                ans %= MOD;
            }

            return (int) ans;
        }

        private List<List<Integer>> getFactors(int maxValue) {
            List<List<Integer>> factors = new ArrayList<>(maxValue + 1);

            // 初始化列表
            for (int i = 0; i <= maxValue; i++) {
                factors.add(new ArrayList<>());
            }

            for (int i = 1; i <= maxValue; ++i) {
                // 從 i * 2 開始，因為需要嚴格遞增
                for (int j = i * 2; j <= maxValue; j += i) {
                    factors.get(j).add(i);
                }
            }

            return factors;
        }

        private long nCk(int n, int k, long[][] mem) {
            if (k == 0) return 1;
            if (n == k) return 1;
            if (mem[n][k] != -1) return mem[n][k];

            return mem[n][k] = (nCk(n - 1, k, mem) + nCk(n - 1, k - 1, mem)) % MOD;
        }
    }
}
