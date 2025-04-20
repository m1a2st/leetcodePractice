package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No2406 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.minGroups(new int[][]{{1, 5}, {1, 10}, {2, 3}, {6, 8}, {5, 10}}));
    }


    class Solution {
        public int minGroups(int[][] intervals) {
            // Stores `right`s.
            Queue<Integer> minHeap = new PriorityQueue<>();

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            for (int[] interval : intervals) {
                // There's no overlap, so we can reuse the same group.
                if (!minHeap.isEmpty() && interval[0] > minHeap.peek())
                    minHeap.poll();
                
                minHeap.offer(interval[1]);
            }

            return minHeap.size();
        }
    }
}
