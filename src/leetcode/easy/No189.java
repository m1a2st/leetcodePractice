package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class No189 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ints, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            int[] ans = new int[len];
            int mod = k % len;
            for (int i = len - mod, j = 0; i < len; i++, j++) {
                ans[j] = nums[i];
            }
            for (int i = 0, j = mod; i < len - mod; i++, j++) {
                ans[j] = nums[i];
            }
            System.arraycopy(ans, 0, nums, 0, len);
        }
    }
}
