package leetcode.medium;

public class No198 {

    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int n = nums.length;
            int[] rob = new int[n];
            rob[0] = nums[0];
            rob[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
            }
            return rob[n - 1];
        }
    }

    static class SolutionNew {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            if (len == 1) return nums[0];
            int[] rob = new int[len];
            rob[0] = nums[0];
            rob[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
            }
            return rob[len - 1];
        }
    }

    class SolutionThird {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }
            int[] ans = new int[len];
            ans[0] = nums[0];
            ans[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                nums[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
            }
            return ans[len - 1];
        }
    }
}
