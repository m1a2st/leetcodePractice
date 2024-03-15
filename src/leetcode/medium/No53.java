package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No53 {

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5};

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
