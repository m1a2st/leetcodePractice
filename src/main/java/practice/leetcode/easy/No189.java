package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No189 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ints, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;
            shift(nums, 0, len - 1);
            shift(nums, 0, k - 1);
            shift(nums, k, len - 1);
        }

        private void shift(int[] nums, int left, int right) {
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
