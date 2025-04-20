package practice.leetcode.medium;

import java.util.Stack;

public class No2390 {

    class Solution {
        public String removeStars(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                Character c = stack.pop();
                ans.append(c);
            }
            return ans.reverse().toString();
        }
    }

    class SolutionNew {
        public String removeStars(String s) {
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (!ans.isEmpty() && c == '*') {
                    ans.deleteCharAt(ans.length() - 1);
                } else {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
}
