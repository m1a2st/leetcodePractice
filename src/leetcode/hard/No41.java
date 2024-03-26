package leetcode.hard;

import org.junit.jupiter.api.Test;

public class No41 {

    @Test
    public void test() {
        new Solution().firstMissingPositive(new int[]{1});
    }

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            boolean[] cache = new boolean[len + 1];
            for (int num : nums) {
                if (num > 0 && num < len + 1) {
                    cache[num] = true;
                }
            }
            for (int i = 1; i < len + 1; i++) {
                if (!cache[i]) {
                    return i;
                }
            }
            return len + 1;
        }
    }

    class SolutionCorrect {
        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                int correct = nums[i] - 1;
                if (correct != i && nums[i] > 0 && nums[i] < nums.length) {
                    if (nums[i] != nums[correct]) {
                        swap(nums, i, correct);
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != j + 1) {
                    return j + 1;
                }
            }
            return nums.length + 1;
        }

        static void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }
}
