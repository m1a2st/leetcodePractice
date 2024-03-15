package lintcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class No1001 {

    @Test
    public void test() {
        int[] ints = new Solution().asteroidCollision(new int[]{5, -5, 10});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void test1() {
        int[] ints = new Solution().asteroidCollision(new int[]{10, 2, -5});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

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
                    if (a1 * a2 > 0 || (a1 > 0 && a2 < 0)) {
                        stack.push(a2);
                        stack.push(a1);
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
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
