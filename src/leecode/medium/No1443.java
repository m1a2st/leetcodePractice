package leecode.medium;

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
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            List<Integer>[] graph = new List[n];

            for (int i = 0; i < n; ++i) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                final int u = edge[0];
                final int v = edge[1];
                graph[u].add(v);
                graph[v].add(u);
            }

            return dfs(graph, 0, new boolean[n], hasApple);
        }

        private int dfs(List<Integer>[] graph, int u, boolean[] seen, List<Boolean> hasApple) {
            seen[u] = true;
            int totalCost = 0;

            for (final int v : graph[u]) {
                if (seen[v])
                    continue;
                final int cost = dfs(graph, v, seen, hasApple);
                if (cost > 0 || hasApple.get(v))
                    totalCost += cost + 2;
            }

            return totalCost;
        }
    }
}
