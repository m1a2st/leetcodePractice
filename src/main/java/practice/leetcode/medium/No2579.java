package practice.leetcode.medium;

public class No2579 {

    class Solution {
        public long coloredCells(int n) {
            return (long) n * n + (long) (n - 1) * (n - 1);
        }
    }
}
