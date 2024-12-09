package parctice.leetcode.medium;

public class No787 {

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] dist = new int[n];
            int[] prev = new int[n];

            // Initialize distance array
            for (int i = 0; i < n; i++) {
                prev[i] = Integer.MAX_VALUE;
                dist[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i <= k; i++) {
                prev[src] = 0;
                for (int[] flight : flights) {
                    int s = flight[0], d = flight[1], cost = flight[2];

                    if (prev[s] == Integer.MAX_VALUE) {
                        continue;
                    }

                    if (prev[s] + cost < dist[d]) {
                        dist[d] = prev[s] + cost;
                    }
                }
                System.arraycopy(dist, 0, prev, 0, dist.length);
            }
            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }
    }
}
