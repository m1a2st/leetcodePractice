package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No456 {

    @Test
    public void test() {
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 3, 4, 2}));
    }

    class Solution {
        public boolean find132pattern(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack
            int ak = Integer.MIN_VALUE;                // We want to find a seq ai < ak < aj.

            for (int i = nums.length - 1; i >= 0; --i) {
                // ai < ak, we're done because ai must also smaller than aj
                if (nums[i] < ak)
                    return true;
                while (!stack.isEmpty() && stack.peek() < nums[i])
                    ak = stack.pop();
                stack.push(nums[i]); // nums[i] is a candidate of aj.
            }
            return false;
        }
    }
}
