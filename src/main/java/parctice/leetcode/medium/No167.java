package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author m1a2st
 * @Date 2023/6/6
 * @Version v1.0
 */
public class No167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l = 0;
            int r = numbers.length - 1;

            while (numbers[l] + numbers[r] != target)
                if (numbers[l] + numbers[r] < target)
                    ++l;
                else
                    --r;

            return new int[]{l + 1, r + 1};
        }
    }

    @Test
    public void test() {
        int[] numbers = {-1, 0};
        int target = -1;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
