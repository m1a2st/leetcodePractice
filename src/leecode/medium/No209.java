package leecode.medium;

import org.junit.Test;

public class No209 {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right];
                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
