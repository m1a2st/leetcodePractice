package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No2485 {

    @Test
    public void test() {
        int i = new SolutionMath().pivotInteger(8);
    }

    class Solution {
        public int pivotInteger(int n) {
            if (n == 1) return 1;
            int rightSum = 0;
            int left = 0, right = n;
            while (left <= right) {
                rightSum += right;
                while (rightSum - left >= 0) {
                    rightSum -= left;
                    left++;
                }
                right--;
                if (left == right && rightSum == 0) {
                    return left;
                }
            }
            return -1;
        }
    }

    class SolutionMath {
        public int pivotInteger(int n) {
            int y = n * (n + 1) / 2;
            int x = (int) Math.sqrt(y);
            if (x * x == y) return x;
            else return -1;
        }
    }
}
