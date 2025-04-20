package practice.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class No2696 {

    class Solution {
        public int minLength(String s) {
            String ab = "AB", cd = "CD";
            while (s.contains(ab) || s.contains(cd)) {
                s = s.replace(ab, "");
                s = s.replace(cd, "");
            }
            return s.length();
        }
    }

    class SolutionStack {
        public int minLength(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                stack.push(c);
                boolean op = true;
                while (stack.size() > 1 && op) {
                    char top = stack.pop();
                    if (stack.peek() == 'A' && top == 'B') stack.pop();
                    else if (stack.peek() == 'C' && top == 'D') stack.pop();
                    else {
                        stack.push(top);
                        op = false;
                    }
                }
            }
            return stack.size();
        }
    }
}
