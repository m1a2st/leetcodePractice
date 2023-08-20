package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/8/18
 * @Version v1.0
 */
public class No268 {

    class Solution {
        public int missingNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans += i;
                ans -= nums[i];
            }
            return ans;
        }
    }

    class SolutionNew {
        public int missingNumber(int[] nums) {
            int ans = nums.length;

            for (int i = 0; i < nums.length; ++i)
                ans ^= i ^ nums[i];

            return ans;
        }
    }
}
