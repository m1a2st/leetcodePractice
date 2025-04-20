package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author m1a2st
 * @Date 2023/6/16
 * @Version v1.0
 */
public class No739 {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; ++i) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    final int index = stack.pop();
                    ans[index] = i - index;
                }
                stack.push(i);
            }
            return ans;
        }
    }

    class SolutionNew {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!queue.isEmpty() && temperatures[queue.peek()] < temperatures[i]) {
                    Integer pop = queue.pop();
                    ans[pop] = i - pop;
                }
                queue.push(i);
            }
            return ans;
        }
    }

    @Test
    public void Test() {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = solution.dailyTemperatures(temperatures);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
