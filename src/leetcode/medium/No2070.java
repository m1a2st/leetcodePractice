package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class No2070 {

    class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            int[] ans = new int[queries.length];
            int[] maxBeautySoFar = new int[items.length + 1];

            Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < items.length; ++i)
                maxBeautySoFar[i + 1] = Math.max(maxBeautySoFar[i], items[i][1]);

            for (int i = 0; i < queries.length; ++i) {
                final int index = firstGreater(items, queries[i]);
                ans[i] = maxBeautySoFar[index];
            }

            return ans;
        }

        private int firstGreater(int[][] items, int q) {
            int l = 0;
            int r = items.length;
            while (l < r) {
                final int m = (l + r) / 2;
                if (items[m][0] > q)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }
}
