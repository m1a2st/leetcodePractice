package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class No1249 {

    @Test
    public void test() {
        System.out.println(new Solution().minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Pair> stack = new Stack<>();
            char[] arr = s.toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                char c = arr[i];
                if (c == '(') {
                    stack.push(new Pair(c, i));
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        Pair p1 = stack.peek();
                        if (p1.c == '(') {
                            stack.pop();
                        } else {
                            stack.push(new Pair(c, i));
                        }
                    } else {
                        stack.push(new Pair(c, i));
                    }
                }
            }
            StringBuilder sb = new StringBuilder(s);
            while (!stack.isEmpty()) {
                Pair pop = stack.pop();
                sb.delete(pop.index, pop.index + 1);
            }

            return sb.toString();
        }


        class Pair {
            char c;
            int index;

            public Pair(char c, int index) {
                this.c = c;
                this.index = index;
            }
        }
    }
}
