package practice.leetcode.easy;

import java.util.PriorityQueue;

public class No1464 {

    class Solution {
        public int maxProduct(int[] nums) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
                if (queue.size() > 2) {
                    queue.poll();
                }
            }
            return (queue.poll() - 1) * (queue.poll() - 1);
        }
    }

    class SolutionNew {
        public int maxProduct(int[] nums) {
            int large = nums[0];
            int secondLarge = nums[1];
            if (secondLarge > large) {
                int temp = secondLarge;
                secondLarge = large;
                large = temp;
            }
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] > large) {
                    secondLarge = large;
                    large = nums[i];
                } else if (nums[i] > secondLarge) {
                    secondLarge = nums[i];
                }
            }
            return (large - 1) * (secondLarge - 1);
        }
    }
}
