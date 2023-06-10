package leecode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/6/7
 * @Version v1.0
 */
public class No11 {

    class Solution {
        public int maxArea(int[] height) {
            int len = height.length;
            int l = 0, r = len - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]);
                ans = Math.max(ans, area * (r - l));
                if (height[l] <= height[r]) {
                    ++l;
                } else {
                    --r;
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
