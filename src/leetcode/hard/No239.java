package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No239 {


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(solution.maxSlidingWindow(
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    class Solution{
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int[] ans = new int[len - k + 1];
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                    dq.poll();
                }
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }
                dq.offer(i);
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[dq.peek()];
                }
            }
            return ans;
        }
    }
}
