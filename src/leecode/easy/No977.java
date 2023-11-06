package leecode.easy;

import org.junit.Test;

import java.util.Arrays;

public class No977 {

    class Solution {
        public int[] sortedSquares(int[] nums) {
            return Arrays.stream(nums)
                    .map(n -> (int) Math.pow(n, 2))
                    .sorted()
                    .toArray();
        }
    }

    class SolutionNew {
        public int[] sortedSquares(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            int left = 0, right = len - 1, index = len - 1;
            while (left <= right) {
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    res[index] = (int) Math.pow(nums[right], 2);
                    index--;
                    right--;
                } else {
                    res[index] = (int) Math.pow(nums[left], 2);
                    index--;
                    left++;
                }
            }
            return res;
        }
    }
}
