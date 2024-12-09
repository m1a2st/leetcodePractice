package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No367 {

    @Test
    public void test() {
        System.out.println(new Solution().isPerfectSquare(16));
    }

    class SolutionNew {
        public boolean isPerfectSquare(int num) {
            return Math.pow((int) Math.sqrt(num), 2) == num;
        }
    }

    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) return true;
            int left = 0, right = num;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                double pow = Math.pow(mid, 2);
                if (pow == num) {
                    return true;
                } else if (pow > num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
