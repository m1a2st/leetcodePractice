package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No3392 {
    
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, -4, -1, 4};
        System.out.println(solution.countSubarrays(nums)); // Output: 2
    }

    class Solution {
        public int countSubarrays(int[] nums) {
            int counter = 0;
            int n = nums.length;
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] % 2 == 0 && (nums[i] / 2 == nums[i - 1] + nums[i + 1])) {
                    counter++;
                }
            }
            return counter;
        }
    }
}
