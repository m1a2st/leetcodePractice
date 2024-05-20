package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author m1a2st
 * @Date 2023/6/13
 * @Version v1.0
 */
public class No155 {

    class MinStack {

        List<Integer> stack;

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);
        }

        public void pop() {
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                min = Math.min(min, integer);
            }
            return min;
        }
    }

    class MinStackGood {
        public void push(int x) {
            if (stack.isEmpty())
                stack.push(new int[]{x, x});
            else
                stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }

        private final Stack<int[]> stack = new Stack<>(); // {x, min}
    }

    @Test
    public void test() {
        MinStackGood minStackGood = new MinStackGood();
        minStackGood.push(2);
        minStackGood.push(3);
        minStackGood.push(4);
        minStackGood.push(5);
        minStackGood.push(1);
        minStackGood.push(0);
        minStackGood.pop();
        minStackGood.pop();
        minStackGood.pop();
    }

    class MinStackNew {

        Stack<int[]> stack = new Stack<>();

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
