package practice.leetcode.medium;

public class No48 {

    class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            int[][] temp = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    temp[len - j - 1][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < len; i++) {
                System.arraycopy(temp[i], 0, matrix[i], 0, len);
            }
        }
    }
}
