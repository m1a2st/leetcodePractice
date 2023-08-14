package leecode.easy;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/14
 * @Version v1.0
 */
public class No136 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }



    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
