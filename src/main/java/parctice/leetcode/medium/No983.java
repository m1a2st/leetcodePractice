package parctice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class No983 {


    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int ans = 0;
            Queue<Pair> last7 = new ArrayDeque<>(); // [day, cost]
            Queue<Pair> last30 = new ArrayDeque<>();

            for (final int day : days) {
                while (!last7.isEmpty() && last7.peek().key + 7 <= day)
                    last7.poll();
                while (!last30.isEmpty() && last30.peek().key + 30 <= day)
                    last30.poll();
                last7.offer(new Pair(day, ans + costs[1]));
                last30.offer(new Pair(day, ans + costs[2]));
                ans = Math.min(ans + costs[0], Math.min(last7.peek().value, last30.peek().value));
            }

            return ans;
        }
    }
    
    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
