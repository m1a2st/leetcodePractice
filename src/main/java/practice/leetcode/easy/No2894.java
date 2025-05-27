package practice.leetcode.easy;

public class No2894 {

    class Solution {
        public int differenceOfSums(int n, int m) {
            final int sum = (1 + n) * n / 2;
            final int num2 = getDivisibleSum(n, m);
            final int num1 = sum - num2;
            return num1 - num2;
        }

        // Returns the sum of all the integers in [1, n] that are divisible by m.
        private int getDivisibleSum(int n, int m) {
            final int last = n / m * m;
            if (last == 0)
                return 0;
            final int count = (last - m) / m + 1;
            return (m + last) * count / 2;
        }
    }
}
