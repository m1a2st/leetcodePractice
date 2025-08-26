package practice.leetcode.easy;

public class No3000 {

    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int n = dimensions.length;
            int maxDiagonal = Integer.MIN_VALUE;
            int maxArea = 0;

            for (int[] dimension : dimensions) {
                int a = dimension[0];
                int b = dimension[1];

                int diagonalSq = a * a + b * b;  // avoid sqrt
                int area = a * b;

                if (diagonalSq > maxDiagonal) {
                    maxDiagonal = diagonalSq;
                    maxArea = area;
                } else if (diagonalSq == maxDiagonal && area > maxArea) {
                    // tie case: pick the larger area
                    maxArea = area;
                }
            }

            return maxArea;
        }
    }
}
