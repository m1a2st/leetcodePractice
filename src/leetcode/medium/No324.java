package leetcode.medium;

import java.util.PriorityQueue;

public class No324 {

    class Solution {
        public void wiggleSort(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.offer(num);
            }
            for (int i = 0; i < nums.length; i++) {
                if ((i & 1) == 0) {
                    nums[i] = pq.poll();
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if ((i & 1) == 1) {
                    nums[i] = pq.poll();
                }
            }
        }
    }
}
