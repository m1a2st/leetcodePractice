package parctice.leetcode.easy;

public class No796 {

    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            return (s + s).contains(goal);
        }
    }
}
