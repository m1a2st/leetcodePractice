package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No295 {

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }


    class MedianFinder {

        private final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private final Queue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            return maxHeap.size() == minHeap.size() ?
                    (double) (maxHeap.peek() + minHeap.peek()) / 2.0 : (double) maxHeap.peek();
        }
    }

    class MedianFinderNew {

        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();
        }
    }

}
