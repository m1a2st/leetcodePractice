package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/6/7
 * @Version v1.0
 */
public class No11 {

    /**
     * 1. 先找出左邊和右邊的高度較小的那個
     * 2. 計算面積
     * 3. 移動高度較小的那邊
     */
    class Solution {
        public int maxArea(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                int h = Math.min(height[left], height[right]);
                ans = Math.max(ans, h * (right - left));
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        int i = solution.maxArea(height);
        assertEquals(49, i);
    }

    @Test
    public void test2() {
        int[] height = {1, 1};
        Solution solution = new Solution();
        int i = solution.maxArea(height);
        assertEquals(1, i);
    }
}
