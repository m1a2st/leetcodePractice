package parctice.leetcode.contest;

import org.junit.jupiter.api.Test;

public class No127 {

    class Solution100272 {
        public int minimumSubarrayLength(int[] nums, int k) {
            int len = nums.length;
            int left = 0, right = 0;
            int sum = 0;
            int ans = Integer.MAX_VALUE;
            while (right < len) {
                sum |= nums[right];
                while (sum >= k && left <= right) {
                    ans = Math.min(ans, right - left + 1);
                    sum &= ~nums[left];
                    left++;
                }
                right++;
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    @Test
    public void test() {
        System.out.println(3 & ~2);
    }
}
