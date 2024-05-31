package leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/8/23
 * @Version v1.0
 */
public class No152 {

    class Solution {

        public int maxProduct(int[] nums) {
            int n = nums.length;
            int maxProduct = nums[0];
            int minProduct = nums[0];
            int result = nums[0];

            for (int i = 1; i < n; i++) {
                if (nums[i] < 0) {
                    // 交換 maxProduct 和 minProduct
                    int temp = maxProduct;
                    maxProduct = minProduct;
                    minProduct = temp;
                }

                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);

                result = Math.max(result, maxProduct);
            }

            return result;
        }

    }

    class SolutionNew {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;

            int product = 1;

            for (int num : nums) {
                product *= num;
                max = Math.max(product, max);
                if (product == 0)
                    product = 1;
            }

            product = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                product *= nums[i];
                max = Math.max(product, max);
                if (product == 0)
                    product = 1;
            }

            return max;
        }
    }
}
