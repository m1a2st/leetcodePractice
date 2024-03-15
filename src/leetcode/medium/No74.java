package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/19
 * @Version v1.0
 */
public class No74 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int x = matrix.length;
            int y = matrix[0].length;
            int left = 0, right = x * y;
            while (left < right) {
                int mid = (right + left) / 2;
                int i = mid / x;
                int j = mid % x;
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return false;
        }
    }

    @Test
    public void Test() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean ans = solution.searchMatrix(matrix, target);
        assertTrue(ans);
    }

    @Test
    public void Test2() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        boolean ans = solution.searchMatrix(matrix, target);
        Assertions.assertFalse(ans);
    }
}
