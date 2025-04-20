package practice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No84 {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int len = heights.length;
            for (int i = 0; i <= len; i++) {
                while (!stack.isEmpty() && (i == len || heights[stack.peek()] > heights[i])) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                stack.push(i);
            }

            return ans;
        }
    }

    @Test
    public void test() {
        new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    class SolutionNew {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            Deque<Integer> cache = new ArrayDeque<>();
            int len = heights.length;
            for (int i = 0; i <= len; i++) {
                while (!cache.isEmpty() && (i == len || heights[cache.peek()] > heights[i])) {
                    int h = heights[cache.pop()];
                    int w = cache.isEmpty() ? i : i - cache.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                cache.push(i);
            }
            return ans;
        }
    }

}
