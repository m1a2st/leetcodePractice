package main.java.parctice.leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/8/23
 * @Version v1.0
 */
public class No152 {

    /**
     * 1. 使用動態規劃
     * 2. 使用兩個變量 maxProduct 和 minProduct 分別存儲最大積和最小積
     * 3. 遍歷數組，當遇到負數時，交換 maxProduct 和 minProduct
     * 4. 每次遍歷時，更新 maxProduct 和 minProduct，條件是若是乘積小於 nums[i]，則更新為 nums[i]
     * 5. 每次遍歷時，更新 ans
     */
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int maxProduct = nums[0];
            int minProduct = nums[0];
            int ans = nums[0];

            for (int i = 1; i < n; i++) {
                if (nums[i] < 0) {
                    // 交換 maxProduct 和 minProduct
                    int temp = maxProduct;
                    maxProduct = minProduct;
                    minProduct = temp;
                }
                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);

                ans = Math.max(ans, maxProduct);
            }

            return ans;
        }
    }
}
