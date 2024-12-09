package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No253 {

    @Test
    public void test() {
        System.out.println(new Solution().minMeetingRooms(new int[][]{{1, 30}, {29, 35}, {40, 41}}));
    }

    /**
     * 1. 對起始時間做排序
     * 2. 使用 PriorityQueue 來存放結束時間
     * 3. 當 PriorityQueue 不為空且 PriorityQueue 的頂端小於等於當前區間的起始時間時，代表
     *   有會議結束，所以將 PriorityQueue 的頂端移除
     * 4. 將當前區間的結束時間加入 PriorityQueue
     * 5. 取 PriorityQueue 的大小為答案
     */
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int ans = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int[] interval : intervals) {
                while (!pq.isEmpty() && pq.peek() <= interval[0]) {
                    pq.poll();
                }
                pq.offer(interval[1]);
                ans = Math.max(ans, pq.size());
            }
            return ans;
        }
    }
}
