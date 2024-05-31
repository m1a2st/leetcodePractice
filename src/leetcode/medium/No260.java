package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No260 {

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(nums)));
    }

    class Solution {
        public int[] singleNumber(int[] nums) {
            int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
            int lowbit = xors & -xors;
            int[] ans = new int[2];

            for (final int num : nums)
                if ((num & lowbit) > 0)
                    ans[0] ^= num;
                else
                    ans[1] ^= num;

            return ans;
        }
    }
}
