package leecode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    static class Solution {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                    dq.poll();
                }
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }
                dq.offer(i);
                if (i >= k - 1) {
                    res[i - k + 1] = nums[dq.peek()];
                }
            }
            return res;
        }
    }
}
