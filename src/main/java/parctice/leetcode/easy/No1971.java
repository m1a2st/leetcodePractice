package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1971 {

    @Test
    public void test() {
        new Solution().validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
    }

    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            if (edges.length == 0) return true;
            boolean[] visited = new boolean[n];
            boolean flag = true;
            visited[source] = true;
            while (flag) {
                flag = false;
                for (int[] edge : edges) {
                    if (visited[edge[0]] != visited[edge[1]]) {
                        visited[edge[0]] = true;
                        visited[edge[1]] = true;
                        flag = true;
                    }
                    if (visited[destination]) return true;
                }
            }
            return false;
        }
    }
}
