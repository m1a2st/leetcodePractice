package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No2348 {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(solution.zeroFilledSubarray(nums));
    }

    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long count = 0;
            long res = 0;
            for (int num : nums) {
                if (num == 0) {
                    count++;
                    res += count;
                } else {
                    count = 0;
                }
            }
            return res;
        }
    }
}
