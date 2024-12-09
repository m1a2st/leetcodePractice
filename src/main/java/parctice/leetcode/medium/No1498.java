package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No1498 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.numSubseq(new int[]{3, 5, 6, 7, 11, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1, 1}, 9);
    }

    class Solution {
        public int numSubseq(int[] nums, int target) {
            final int kMod = 1_000_000_007;
            final int n = nums.length;
            int ans = 0;
            int[] pows = new int[n]; // pows[i] = 2^i % kMod
            pows[0] = 1;

            for (int i = 1; i < n; ++i)
                pows[i] = pows[i - 1] * 2 % kMod;

            Arrays.sort(nums);

            for (int l = 0, r = n - 1; l <= r; )
                if (nums[l] + nums[r] <= target) {
                    ans += pows[r - l];
                    ans %= kMod;
                    ++l;
                } else {
                    --r;
                }

            return ans;
        }
    }
}
