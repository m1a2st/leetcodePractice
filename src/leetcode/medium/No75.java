package leetcode.medium;

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

    class SolutionP {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1, current = 0;
            while (current <= right) {
                if (nums[current] == 2) {
                    swap(nums, current, right);
                    right--;
                } else if (nums[current] == 1) {
                    current++;
                } else {
                    swap(nums, current, left);
                    left++;
                    current++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
        }
    }

    class Solution {
        public void sortColors(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        swap(nums, i, j);
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
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
