package leecode.medium;

import java.util.Arrays;

public class No2616 {

    class Solution {
        public int minimizeMax(int[] nums, int p) {
            if (p == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int l = 0;
            int r = nums[nums.length - 1] - nums[0];

            while (l < r) {
                final int m = (l + r) / 2;
                if (numPairs(nums, m, p))
                    r = m;
                else
                    l = m + 1;
            }

            return l;
        }

        // Returns the # of pairs that can be obtained if the difference between each
        // pair <= `maxDiff`.
        private boolean numPairs(int[] nums, int maxDiff, int p) {
            int pairs = 0;
            for (int i = 1; i < nums.length; ++i) {
                // Greedily pair nums[i] with nums[i - 1].
                if (nums[i] - nums[i - 1] <= maxDiff) {
                    ++pairs;
                    ++i;
                }
                if (pairs == p) {
                    return true;
                }
            }
            return false;
        }
    }
}
