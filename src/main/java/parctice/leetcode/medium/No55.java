package parctice.leetcode.medium;

public class No55 {

    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int jump = nums[0];
            for (int i = 1; i < len; i++) {
                if (jump == 0) {
                    return false;
                }
                jump--;
                jump = Math.max(jump, nums[i]);
            }
            return true;
        }
    }
}
