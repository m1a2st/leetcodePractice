package parctice.leetcode.hard;

public class No2999 {

    class Solution {
        public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
            String a = String.valueOf(start);
            String b = String.valueOf(finish);
            String aWithLeadingZeros = "0".repeat(b.length() - a.length()) + a;

            long[][][] mem = new long[b.length()][2][2];
            for (int i = 0; i < b.length(); i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        mem[i][j][k] = -1;
                    }
                }
            }

            String sWithLeadingZeros = "0".repeat(b.length() - s.length()) + s;
            return count(aWithLeadingZeros, b, 0, limit, s, true, true, mem);
        }

        // Returns the number of powerful integers, considering the i-th digit, where
        // `tight1` indicates if the current digit is tightly bound for `a` and
        // `tight2` indicates if the current digit is tightly bound for `b`.
        private long count(String a, String b, int i, int limit, String s, boolean tight1, boolean tight2, long[][][] mem) {
            if (i + s.length() == b.length()) {
                String aMinSuffix = tight1 ? a.substring(a.length() - s.length()) : "0".repeat(s.length());
                String bMaxSuffix = tight2 ? b.substring(b.length() - s.length()) : "9".repeat(s.length());

                long suffix = Long.parseLong(s);
                return (Long.parseLong(aMinSuffix) <= suffix && suffix <= Long.parseLong(bMaxSuffix)) ? 1 : 0;
            }

            if (mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0] != -1) {
                return mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0];
            }

            long res = 0;
            int minDigit = tight1 ? (a.charAt(i) - '0') : 0;
            int maxDigit = tight2 ? (b.charAt(i) - '0') : 9;

            for (int d = minDigit; d <= maxDigit; ++d) {
                if (d > limit) continue;

                boolean nextTight1 = tight1 && (d == minDigit);
                boolean nextTight2 = tight2 && (d == maxDigit);

                res += count(a, b, i + 1, limit, s, nextTight1, nextTight2, mem);
            }

            mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0] = res;
            return res;
        }
    }
}
