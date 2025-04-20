package practice.leetcode.medium;

public class No2064 {


    class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            int l = 1;
            int r = getMax(quantities);

            while (l < r) {
                final int m = (l + r) / 2;
                if (numStores(quantities, m) <= n)
                    r = m;
                else
                    l = m + 1;
            }

            return l;
        }

        private static int getMax(int[] quantities) {
            int max = 0;
            for (int q : quantities) {
                max = Math.max(max, q);
            }
            return max;
        }

        private int numStores(int[] quantities, int m) {
            int totalStores = 0;
            for (int q : quantities) {
                totalStores += (q - 1) / m + 1;
            }
            return totalStores;
        }
    }
}
