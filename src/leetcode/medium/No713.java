package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No713 {

    @Test
    public void test() {
        new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1){
                return 0;
            }

            int ans = 0;
            int prod = 1;

            for (int l = 0, r = 0; r < nums.length; ++r) {
                prod *= nums[r];
                while (prod >= k){
                    prod /= nums[l++];
                }
                ans += r - l + 1;
            }

            return ans;
        }
    }
}
