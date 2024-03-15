package leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No703 {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8

    }

    static class KthLargestOld {

        private final Queue<Integer> pq = new PriorityQueue<>();
        private final int k;

        public KthLargestOld(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                pq.add(i);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }

    static class KthLargest {

        Queue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                pq.offer(i);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }

}
