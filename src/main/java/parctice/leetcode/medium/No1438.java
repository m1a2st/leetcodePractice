package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class No1438 {
    
    @Test
    public void test() {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(new Solution().longestSubarray(nums, limit));
    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> max = new ArrayDeque<>();
            Deque<Integer> min = new ArrayDeque<>();
            int len = nums.length;
            int left = 0;
            int ans = 0;

            for (int right = 0; right < len; ++right) {
                int num = nums[right];
                while (!max.isEmpty() && max.peekLast() < num) {
                    max.pollLast();
                }
                max.addLast(num);
                while (!min.isEmpty() && min.peekLast() > num) {
                    min.pollLast();
                }
                min.addLast(num);
                
                while (max.peekFirst() - min.peekFirst() > limit) {
                    if (max.peekFirst() == nums[left]) {
                        max.pollFirst();
                    }
                    if (min.peekFirst() == nums[left]) {
                        min.pollFirst();
                    }
                    ++left;
                }
                
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
}
