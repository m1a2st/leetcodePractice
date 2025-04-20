package practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class No735 {

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (Integer aster : asteroids) {
                while (!stack.isEmpty() && stack.getLast() > 0 && aster < 0) {
                    int pre = stack.pollLast();
                    if (pre > -aster) {
                        aster = pre;
                    } else if (pre == -aster) {
                        aster = 0;
                    }
                }
                if (aster == 0) {
                    continue;
                }
                stack.addLast(aster);
            }
            int size = stack.size();
            int[] res = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                res[i] = stack.pollLast();
            }
            return res;
        }
    }
}
