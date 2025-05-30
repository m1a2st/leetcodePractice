package practice.leetcode.medium;

import java.util.Arrays;

public class No945 {

    class Solution {
        public int minIncrementForUnique(int[] nums) {
            Arrays.sort(nums);
            int prev = -1;
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (prev >= nums[i]) {
                    ans += (prev - nums[i]) + 1;
                    nums[i] = prev + 1;
                }
                prev = nums[i];
            }
            return ans;
        }
    }
}
