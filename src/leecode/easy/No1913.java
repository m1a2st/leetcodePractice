package leecode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class No1913 {

    class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
        }
    }
}
