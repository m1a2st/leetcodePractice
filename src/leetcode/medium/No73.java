package leetcode.medium;

public class No73 {

    class Solution {

        boolean[][] isVisited;

        public void setZeroes(int[][] matrix) {
            int x = matrix.length;
            int y = matrix[0].length;
            isVisited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (!isVisited[i][j]) {
                        if (matrix[i][j] == 0) {
                            modifyMatrix(matrix, i, j);
                        } else {
                            isVisited[i][j] = true;
                        }
                    }
                }
            }
        }

        private void modifyMatrix(int[][] matrix, int i, int j) {
            int xLen = matrix.length;
            int yLen = matrix[0].length;
            for (int x = 0; x < xLen; x++) {
                if (matrix[x][j] != 0) {
                    matrix[x][j] = 0;
                    isVisited[x][j] = true;
                }
            }
            for (int y = 0; y < yLen; y++) {
                if (matrix[i][y] != 0) {
                    matrix[i][y] = 0;
                    isVisited[i][y] = true;
                }
            }
        }
    }
}
