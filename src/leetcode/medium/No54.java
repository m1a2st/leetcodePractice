package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class No54 {

    @Test
    public void test() {
        new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    class Solution {

        ArrayList<Integer> ans = new ArrayList<>();

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return ans;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

            while (left <= right && top <= bottom) {
                // Traverse right
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                // Traverse down
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                // Traverse left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                // Traverse up
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return ans;
        }
    }
}
