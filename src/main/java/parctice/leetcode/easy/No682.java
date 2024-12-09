package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class No682 {

    @Test
    public void test1() {
        Solution solution = new Solution();
        String[] operations = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int result = solution.calPoints(operations);
        System.out.println(result);
    }

    class Solution {
        public int calPoints(String[] operations) {
            Stack<Integer> numbers = new Stack<>();
            for (String operation : operations) {
                switch (operation) {
                    case "+": {
                        Integer n1 = numbers.pop();
                        Integer n2 = numbers.pop();
                        numbers.push(n2);
                        numbers.push(n1);
                        numbers.push(n1 + n2);
                        break;
                    }
                    case "D": {
                        Integer n1 = numbers.peek();
                        numbers.push(n1 * 2);
                        break;
                    }
                    case "C": {
                        Integer n1 = numbers.pop();
                        break;
                    }
                    default: {
                        numbers.push(Integer.valueOf(operation));
                        break;
                    }
                }

            }
            return numbers.stream().reduce(Integer::sum).orElse(0);
        }
    }
}
