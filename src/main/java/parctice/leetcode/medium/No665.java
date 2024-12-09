package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No665 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.checkPossibility(new int[]{4, 2, 1});
    }

    class Solution {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] < nums[i - 1]) {
                    ++count;
                    if (count > 1) return false;
                    if (i > 1 && nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                }
            }
            return true;
        }
    }
}
