package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No1443 {

    @Test
    public void test() {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = List.of(false, false, true, false, true, true, false);
        Solution solution = new Solution();
        System.out.println(solution.minTime(n, edges, hasApple));
    }

    class Solution {

        List<Integer>[] graph;
        boolean[] seen;

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            graph = new List[n];
            seen = new boolean[n];

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                graph[u].add(v);
                graph[v].add(u);
            }
            return dfs(0, hasApple);
        }

        private int dfs(int u, List<Boolean> hasApple) {
            seen[u] = true;
            int totalPath = 0;
            for (Integer i : graph[u]) {
                if (seen[i]) continue;
                int cost = dfs(i, hasApple);
                if (hasApple.get(i) || cost > 0) {
                    totalPath += cost + 2;
                }
            }
            return totalPath;
        }
    }
}
