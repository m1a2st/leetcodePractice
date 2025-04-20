package practice.leetcode.easy;

import java.util.Stack;

public class No1544 {

    class Solution {
        public String makeGood(String s) {
            StringBuilder ans = new StringBuilder();
            char[] array = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : array) {
                stack.push(c);
                while (stack.size() > 1) {
                    Character c1 = stack.pop();
                    Character c2 = stack.pop();
                    if (c1 + 32 == c2 || c1 - 32 == c2) {
                    } else {
                        stack.push(c2);
                        stack.push(c1);
                        break;
                    }
                }
            }
            while (!stack.isEmpty()) {
                ans.insert(0, stack.pop());
            }
            return ans.toString();
        }
    }

    class SolutionBest {
        public String makeGood(String s) {
            if (s.isEmpty() || s.length() == 1)
                return s;
            StringBuilder sb = new StringBuilder(s);
            int index = 0;
            while (index < sb.length() - 1) {
                char leftChar = sb.charAt(index);
                char rightChar = sb.charAt(index + 1);

                if (Math.abs(leftChar - rightChar) == 32) {
                    sb.delete(index, index + 2);
                    if (index > 0)
                        index--;
                } else {
                    index++;
                }
            }
            return sb.toString();
        }
    }
}
