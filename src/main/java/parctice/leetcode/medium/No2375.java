package parctice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class No2375 {

    class Solution {
        public String smallestNumber(String pattern) {
            StringBuilder sb = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>(List.of('1'));

            for (final char c : pattern.toCharArray()) {
                char maxSorFar = stack.peek();
                if (c == 'I')
                    while (!stack.isEmpty()) {
                        maxSorFar = (char) Math.max(maxSorFar, stack.peek());
                        sb.append(stack.pop());
                    }
                stack.push((char) (maxSorFar + 1));
            }

            while (!stack.isEmpty())
                sb.append(stack.pop());

            return sb.toString();
        }
    }
}
