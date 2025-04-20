package practice.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No506 {

    class Solution {
        public String[] findRelativeRanks(int[] score) {
            String[] ans = new String[score.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(s -> -s.score));
            for (int i = 0; i < score.length; i++) {
                pq.offer(new Pair(i, score[i]));
            }
            int index = 1;
            while (!pq.isEmpty()) {
                switch (index++) {
                    case 1 -> ans[pq.poll().index] = "Gold Medal";
                    case 2 -> ans[pq.poll().index] = "Silver Medal";
                    case 3 -> ans[pq.poll().index] = "Bronze Medal";
                    default -> ans[pq.poll().index] = String.valueOf(index - 1);
                }
            }
            return ans;
        }

        class Pair {
            int index;
            int score;

            public Pair(int index, int score) {
                this.index = index;
                this.score = score;
            }
        }
    }
}
