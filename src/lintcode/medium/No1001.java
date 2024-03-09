package lintcode.medium;

import java.util.Stack;

public class No1001 {

    public class Solution {
        /**
         * @param asteroids: a list of integers
         * @return: return a list of integers
         */
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int asteroid : asteroids) {
                stack.push(asteroid);
                while (stack.size() > 1) {
                    Integer a1 = stack.pop();
                    Integer a2 = stack.pop();
                    if (a1 * a2 > 0) {
                        break;
                    } else {
                        if (Math.abs(a1) > Math.abs(a2)) {
                            stack.push(a1);
                        } else if (Math.abs(a1) < Math.abs(a2)) {
                            stack.push(a2);
                        }
                    }
                }
            }
            int[] ans = new int[stack.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
