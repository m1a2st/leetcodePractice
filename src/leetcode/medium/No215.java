package leetcode.medium;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No215 {

    @Test
    public void test() {
        SolutionOld solution = new SolutionOld();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k) pq.poll();
            }
            return pq.peek();
        }
    }

    static class SolutionOld {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int num : nums) {
                pq.offer(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }
}
