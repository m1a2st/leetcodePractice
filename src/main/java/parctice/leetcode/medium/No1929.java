package parctice.leetcode.medium;

public class No1929 {

    class Solution {
        public int[] getConcatenation(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len * 2];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i];
                ans[i + len] = nums[i];
            }
            return ans;
        }
    }
}
