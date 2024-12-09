package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @Author m1a2st
 * @Date 2023/4/10
 * @Version v1.0
 */
public class No20 {

    class SolutionOld {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    @Test
    public void Test() {
        String s = "()";
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isValid(s));
    }

    @Test
    public void Test2() {
        String s = "()[]{}";
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isValid(s));
    }

    @Test
    public void Test3() {
        String s = "(]";
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isValid(s));
    }
}
