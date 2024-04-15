package leetcode.hard;

import org.junit.Test;

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

    class SolutionBad {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            int len = heights.length;
            for (int i = 0; i < len; i++) {
                ans = Math.max(ans, heights[i]);
                for (int j = 1; j <= heights[i]; j++) {
                    int next = i;
                    while (++next < len && heights[next] >= j) {

                    }
                    ans = Math.max(ans, (next - i) * j);
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        new SolutionPQ().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }


    class SolutionPQ {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i <= heights.length; ++i) {
                while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                stack.push(i);
            }

            return ans;
        }
    }
}
