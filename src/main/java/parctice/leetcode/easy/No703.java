package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class No703 {

    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8

    }

    class KthLargest {

        Queue<Integer> pq = new PriorityQueue<>();
        int capacity;

        public KthLargest(int k, int[] nums) {
            capacity = k;
            for (int i : nums) {
                pq.offer(i);
                if (pq.size() > capacity) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > capacity) {
                pq.poll();
            }
            return pq.peek();
        }
    }

}
