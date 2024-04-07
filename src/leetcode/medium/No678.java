package leetcode.medium;

public class No678 {

    class Solution {
        public boolean checkValidString(String s) {
            int min = 0, max = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    min++;
                    max++;
                } else if (c == ')') {
                    min = Math.max(min - 1, 0);
                    max--;
                    if (max < 0) {
                        return false;
                    }
                } else if (c == '*') {
                    min = Math.max(min - 1, 0);
                    max++;
                }
            }
            return min == 0;
        }
    }
}
