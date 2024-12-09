package parctice.leetcode.medium;

public class No962 {

    class Solution {
        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            int[] stack = new int[n];
            int size = 0;
            for (int i = 0; i < n; i++) {
                if (size == 0 || nums[stack[size - 1]] > nums[i]) {
                    stack[size++] = i;
                }
            }
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (size > 0 && nums[stack[size - 1]] <= nums[i]) {
                    res = Math.max(res, i - stack[--size]);
                }
            }
            return res;
        }
    }
}
