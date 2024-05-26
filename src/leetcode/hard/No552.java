package leetcode.hard;

public class No552 {

    class Solution {
        final int MOD = 1_000_000_007;

        public int checkRecord(int n) {
            // porL[i] 表示長度為 i 的且不包含 'A' 的出勤記錄數，並且最後一個字符是 'P' 或 'L'。
            long[] porL = new long[n + 1];
            // p[i] 表示長度為 i 的且不包含 'A' 的出勤記錄數，並且最後一個字符是 'P'。
            long[] p = new long[n + 1];
            porL[0] = p[0] = 1;
            // 有可能是 'P' 或 'L'，所以初始化為 2
            porL[1] = 2;
            p[1] = 1;

            for (int i = 2; i <= n; i++) {
                // 長度為 i 且不包含 'A' 的且最後一個字符是 'P' 的序列數等於長度為 i-1 且不包含 'A'
                // 的任意序列數（無論結尾是 'P' 還是 'L'），因為可以在其後面加一個 'P'。
                p[i] = porL[i - 1];
                // 長度為 i 且不包含 'A' 的且最後一個字符是 'P' 或 'L' 的序列數等於：
                //   長度為 i 且不包含 'A' 的且最後一個字符是 'P' 的序列數（即 p[i]）。
                //   加上長度為 i 且不包含 'A' 的且最後一個字符是 'L' 的序列數。
                //   最後一個字符是 'L' 的序列數等於最後兩個字符是 'PL' 的序列數（p[i-1]）和最後三個字符是 'PPL' 的序列數（p[i-2]）
                porL[i] = (p[i] + p[i - 1] + p[i - 2]) % MOD;
            }

            // 初始化結果為長度為 n 且不包含 'A' 的序列數。
            long res = porL[n];
            // 迭代所有可能的位置，在長度為 n-1 的序列中插入一個 'A'，計算所有可能的情況
            for (int i = 0; i < n; i++) {
                // 計算在位置 i 插入 'A' 之後，前面長度為 i 和後面長度為 n-i-1 的所有序列數的乘積。
                long s = (porL[i] * porL[n - i - 1]) % MOD;
                res = (res + s) % MOD;
            }

            return (int) res;
        }
    }
}
