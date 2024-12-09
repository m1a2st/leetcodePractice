package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No2912 {
    
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        public List<List<Integer>> getAncestors(int n, int[][] edges) {

            for (int i = 0; i < n; ++i) {
                ans.add(new ArrayList<>());
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
            }

            for (int i = 0; i < n; ++i) {
                dfs(i, i, new boolean[n]);
            }

            return ans;
        }

        private void dfs(int start, int ancestor, boolean[] seen) {
            seen[start] = true;
            for (int edge : graph.get(start)) {
                if (seen[edge])
                    continue;
                ans.get(edge).add(ancestor);
                dfs(edge, ancestor, seen);
            }
        }
    }
}
