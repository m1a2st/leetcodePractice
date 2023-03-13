package leecode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No238 {

    static class Solution {
        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length, right = 1;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; ++i) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            for (int i = n - 1; i >= 0; --i) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }
}

