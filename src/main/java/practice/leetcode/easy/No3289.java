package practice.leetcode.easy;

public class No3289 {

    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int[] ans = new int[2];
            boolean isFirst = true;
            int[] cache = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                cache[nums[i]]++;
                if (cache[nums[i]] == 2) {
                    if (isFirst) {
                        ans[0] = nums[i];
                        isFirst = false;
                    } else {
                        ans[1] = nums[i];
                    }
                }
            }
            return ans;
        }
    }
}
