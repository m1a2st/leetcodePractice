package practice.leetcode.easy;

import java.util.Arrays;

public class No1608 {

    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);

            if (nums[0] >= nums.length) {
                return nums.length;
            }

            for (int i = 1; i < nums.length; ++i) {
                int count = nums.length - i;
                if (nums[i - 1] < count && nums[i] >= count) {
                    return count;
                }
            }

            return -1;
        }
    }
}
