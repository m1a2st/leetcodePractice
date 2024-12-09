package parctice.leetcode.medium;

import java.util.Arrays;

public class No3075 {

    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            Arrays.sort(happiness);
            long ans = 0;
            for (int i = 0, len = happiness.length - 1; i < k; i++) {
                int happy = happiness[len--] - i;
                if (happy < 0) {
                    happy = 0;
                }
                ans += happy;
            }
            return ans;
        }
    }
}
