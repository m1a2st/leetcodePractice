package main.java.parctice.leetcode.medium;

import java.util.Arrays;

public class No1637 {

    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            int[] xArr = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                xArr[i] = points[i][0];
            }
            Arrays.sort(xArr);
            int ans = 0;
            for (int i = 0; i < xArr.length - 1; i++) {
                ans = Math.max(ans, xArr[i + 1] - xArr[i]);
            }
            return ans;
        }
    }
}
