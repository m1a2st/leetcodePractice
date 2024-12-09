package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author m1a2st
 * @Date 2023/8/18
 * @Version v1.0
 */
public class No268 {

    class SolutionNew {
        public int missingNumber(int[] nums) {
            int ans = nums.length;

            for (int i = 0; i < nums.length; ++i)
                ans ^= i ^ nums[i];

            return ans;
        }
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans += i + 1 - nums[i];
            }
            return ans;
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(test(new int[]{1, 2, 3, 6})));
    }

    public int[] test(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] ans = new int[nums[len - 1] - len + 1];
        int index = 0;
        int step = 0;
        int j = 0;
        while (j < len) {
            if (step == nums[j]) {
                j++;
                step++;
            } else {
                ans[index++] = step++;
            }
        }
        return ans;
    }
}
