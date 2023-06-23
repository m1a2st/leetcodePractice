package leecode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No150 {

    class SolutionOld {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(token)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("*".equals(token)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.peek();
        }
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(token)) {
                    Integer a1 = stack.pop();
                    Integer a2 = stack.pop();
                    stack.push(a2 - a1);
                } else if ("*".equals(token)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(token)) {
                    Integer a1 = stack.pop();
                    Integer a2 = stack.pop();
                    stack.push(a2 / a1);
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.pop();
        }
    }

    @Test
    public void test() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Solution solution = new Solution();
        Assertions.assertEquals(9, solution.evalRPN(tokens));
    }

    @Test
    public void test2() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.evalRPN(tokens));
    }

    @Test
    public void test3() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution solution = new Solution();
        Assertions.assertEquals(22, solution.evalRPN(tokens));
    }
}
