package main.java.parctice.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No502 {

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int len = profits.length;
            int[][] edge = new int[len][2];
            for (int i = 0; i < len; i++) {
                edge[i][0] = capital[i];
                edge[i][1] = profits[i];
            }
            Arrays.sort(edge, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
            int i = 0;
            for (int j = 0; j < k; j++) {
                while (i < len && edge[i][0] <= w) {
                    pq.offer(edge[i++][1]);
                }
                if (!pq.isEmpty()) {
                    w += pq.poll();
                } else {
                    break;
                }
            }
            return w;
        }
    }
}
