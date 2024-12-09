package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class No867 {

    @Test
    public void testTranspose() {
        No867 no867 = new No867();
        No867.Solution solution = no867.new Solution();

        // Test case 1
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected1 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected1, solution.transpose(matrix1));

        // Test case 2
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] expected2 = {{1, 3, 5}, {2, 4, 6}};
        assertArrayEquals(expected2, solution.transpose(matrix2));

        // Test case 3
        int[][] matrix3 = {{1}};
        int[][] expected3 = {{1}};
        assertArrayEquals(expected3, solution.transpose(matrix3));
    }

    class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] res = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }
    }
}
