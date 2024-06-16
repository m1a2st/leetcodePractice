package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No946 {

    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0; // popped index

            for (final int x : pushed) {
                stack.push(x);
                while (!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pop();
                    ++i;
                }
            }
            return stack.isEmpty();
        }
    }
}
