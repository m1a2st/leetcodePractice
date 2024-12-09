package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No2971 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3});
    }

    class Solution {
        public long largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            long[] dp = new long[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[0] + nums[1];
            long ans = -1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
                if (dp[i - 1] > nums[i]) {
                    ans = dp[i];
                }
            }
            return ans;
        }
    }
}
