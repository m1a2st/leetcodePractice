package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No75 {

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SolutionNew().sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1, current = 0;
            while (current <= right) {
                int num = nums[current];
                if (num == 2) {
                    swap(nums, current, right--);
                } else if (num == 1) {
                    current++;
                } else {
                    swap(nums, left++, current++);
                }
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
    }

    class SolutionNew {
        public void sortColors(int[] nums) {
            int zero = -1;
            int one = -1;
            int two = -1;

            for (int num : nums)
                if (num == 0) {
                    nums[++two] = 2;
                    nums[++one] = 1;
                    nums[++zero] = 0;
                } else if (num == 1) {
                    nums[++two] = 2;
                    nums[++one] = 1;
                } else {
                    nums[++two] = 2;
                }
        }
    }
}