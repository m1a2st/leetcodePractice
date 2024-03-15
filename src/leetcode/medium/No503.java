package leetcode.medium;

import java.util.*;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No503 {

    public static void main(String[] args) {
        Solution.nextGreaterElements(new int[]{1, 2, 1});
    }


    static class Solution {
        public static int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            Arrays.fill(res, -1);
            for (int i = 0; i < n ; i++) {
                while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return res;
        }
    }
}
