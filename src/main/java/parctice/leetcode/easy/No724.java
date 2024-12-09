package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No724 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int res = solution.pivotIndex(nums);
        System.out.println(res);
    }

    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i];
                int tempSum = sum - index;
                if (tempSum % 2 == 0) {
                    int tempHalf = tempSum / 2;
                    if (leftSum == tempHalf) return i;
                }
                leftSum += index;
            }
            return -1;
        }
    }
}
