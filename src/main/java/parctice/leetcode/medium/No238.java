package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No238 {

    static class Solution {
        public static int[] productExceptSelfOld(int[] nums) {
            int n = nums.length, right = 1;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; ++i) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            for (int i = n - 1; i >= 0; --i) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }

        public int[] productExceptSelf(int[] nums) {
            int length = nums.length, right = 1;
            int[] res = new int[length];
            res[0] = 1;
            for (int i = 1; i < length; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            for (int i = length - 1; i >= 0; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }

    class SolutionNew {

        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            res[0] = 1;
            int right = 1;
            // 1 1 2 6
            for (int i = 1; i < len; i++) {
                res[i] = nums[i - 1] * res[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
        int[] nums = {1, 2, 3, 4};
        int[] res = {24, 12, 8, 6};
        int[] result = solution.productExceptSelf(nums);
        IntStream.range(0, res.length).forEach(i -> {
            assert res[i] == result[i];
        });
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {-1, 1, 0, -3, 3};
        int[] res = {0, 0, 9, 0, 0};
        int[] result = solution.productExceptSelf(nums);
        IntStream.range(0, res.length).forEach(i -> {
            assert res[i] == result[i];
        });
    }
}

