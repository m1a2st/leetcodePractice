package parctice.leetcode.easy;

public class No1752 {

    class Solution {
        public boolean check(int[] nums) {
            int canDecrease = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (canDecrease == 0) {
                        return false;
                    }
                    canDecrease--;
                }
            }
            return nums[0] >= nums[nums.length - 1] || canDecrease == 1;
        }
    }
}
