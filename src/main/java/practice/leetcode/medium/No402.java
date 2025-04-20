package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class No402 {

    @Test
    public void test1() {
        String num = "1432219";
        int k = 5;
        System.out.println(new Solution().removeKdigits(num, k));
    }

    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) return "0";

            StringBuilder sb = new StringBuilder();
            LinkedList<Character> stack = new LinkedList<>();

            for (int i = 0; i < num.length(); ++i) {
                while (k > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
                    stack.pollLast();
                    --k;
                }
                stack.addLast(num.charAt(i));
            }

            while (k-- > 0)
                stack.pollLast();

            for (final char c : stack) {
                if (c == '0' && sb.isEmpty())
                    continue;
                sb.append(c);
            }

            return sb.isEmpty() ? "0" : sb.toString();
        }
    }

    class SolutionNew {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) return "0";

            StringBuilder sb = new StringBuilder();
            LinkedList<Character> stack = new LinkedList<>();

            for (char c : num.toCharArray()) {
                while (!stack.isEmpty() && k > 0 && stack.getLast() > c) {
                    stack.pollLast();
                    k--;
                }
                stack.addLast(c);
            }

            while (k-- > 0) {
                stack.pollLast();
            }

            for (final char c : stack) {
                if (c == '0' && sb.isEmpty())
                    continue;
                sb.append(c);
            }

            return sb.isEmpty() ? "0" : sb.toString();
        }
    }
}
