package leecode.medium;

import org.junit.jupiter.api.Test;

public class No213 {

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
        int[] nums = {1, 2, 3, 1};
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[] rob = new int[n + 1], rob1 = new int[n + 1];
            rob[1] = nums[0];
            rob1[2] = nums[1];
            for (int i = 2; i < n; i++) {
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i - 1]);
            }
            for (int i = 3; i <= n; i++) {
                rob1[i] = Math.max(rob1[i - 1], rob1[i - 2] + nums[i - 1]);
            }
            return Math.max(rob[n - 1], rob1[n]);
        }
    }

    static class SolutionNew {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) return nums[0];
            int[] rob = new int[len + 1];
            int[] rob1 = new int[len + 1];
            rob[1] = nums[0];
            rob1[2] = nums[1];
            for (int i = 2; i < len; i++) {
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i - 1]);
            }
            for (int i = 3; i <= len; i++) {
                rob1[i] = Math.max(rob1[i - 1], rob1[i - 2] + nums[i - 1]);
            }
            return Math.max(rob[len - 1], rob1[len]);
        }
    }
}
