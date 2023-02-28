package leecode.medium;

public class No213 {
    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[] f = new int[n + 1], g = new int[n + 1];
            f[1] = nums[0];
            g[2] = nums[1];
            for (int i = 2; i < n; i++) {
                f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
            }
            for (int i = 3; i <= n; i++) {
                g[i] = Math.max(g[i - 1], g[i - 2] + nums[i - 1]);
            }
            return Math.max(f[n - 1], g[n]);
        }
    }
}
