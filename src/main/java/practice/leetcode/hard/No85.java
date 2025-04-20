package practice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class No85 {

    @Test
    public void test0() {
        SolutionNew solution = new SolutionNew();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        assert solution.maximalRectangle(matrix) == 6;
    }


    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0)
                return 0;

            int ans = 0;
            int[] hist = new int[matrix[0].length];

            for (char[] row : matrix) {
                for (int i = 0; i < row.length; ++i)
                    hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
                ans = Math.max(ans, largestRectangleArea(hist));
            }

            return ans;
        }

        private int largestRectangleArea(int[] heights) {
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i <= heights.length; ++i) {
                while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                    final int h = heights[stack.pop()];
                    final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                stack.push(i);
            }

            return ans;
        }
    }

    class SolutionNew {

        public int area(int[] heights) {
            int n = heights.length, start, maxArea = 0;
            Stack<Pair> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                start = i;
                while (!st.isEmpty() && ((st.peek().height) > heights[i])) {
                    Pair pair = st.pop();
                    maxArea = Math.max(maxArea, (i - pair.index) * pair.height);
                    start = pair.index;
                }
                st.push(new Pair(start, heights[i]));
            }
            for (Pair pair : st) {
                maxArea = Math.max(maxArea, (n - pair.index) * pair.height);
            }
            return maxArea;
        }

        public int maximalRectangle(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int ans = 0;
            int[][] matrix1 = new int[n][m];

            for (int i = 0; i < n; i++) {
                matrix1[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    if (i == 0 && matrix[i][j] == '1') {
                        matrix1[i][j] = 1;
                    } else if (i > 0 && matrix[i][j] == '1') {
                        matrix1[i][j] = matrix1[i - 1][j] + 1;
                    } else {
                        matrix1[i][j] = 0;
                    }
                }
                ans = Math.max(ans, area(matrix1[i]));
            }
            return ans;
        }

        class Pair {
            int index;
            int height;

            Pair(int index, int height) {
                this.index = index;
                this.height = height;
            }
        }
    }
}
