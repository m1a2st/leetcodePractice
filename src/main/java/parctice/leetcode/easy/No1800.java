package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1800 {

    @Test
    public void test() {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(new Solution().maxAscendingSum(nums));
    }

    class Solution {
        public int maxAscendingSum(int[] nums) {
            int ans = nums[0];
            int sum = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    sum += nums[i + 1];
                } else {
                    ans = Math.max(ans, sum);
                    sum = nums[i + 1];
                }
            }
            return Math.max(ans, sum);
        }
    }
}
