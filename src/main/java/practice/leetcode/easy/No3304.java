package practice.leetcode.easy;

public class No3304 {

    class Solution {
        public char kthCharacter(int k) {
            return (char) ('a' + Integer.bitCount(k - 1));
        }
    }
}
