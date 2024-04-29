package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class No797 {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, 0, new ArrayList<>());
            return ans;
        }

        private void dfs(int[][] graph, int nth, List<Integer> path) {
            path.add(nth);
            if (nth == graph.length - 1) {
                ans.add(new ArrayList<>(path)); // 添加路徑副本
            } else {
                for (int i : graph[nth]) {
                    dfs(graph, i, path);
                }
            }
            path.remove(path.size() - 1); // 回溯時刪除最後一個節點
        }
    }

    @Test
    public void test() {
        new SolutionNew().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
    }

    class SolutionNew {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, 0, new ArrayList<>());
            return ans;
        }

        private void dfs(int[][] graph, int start, ArrayList<Integer> path) {
            path.add(start);
            if (start == graph.length - 1) {
                ans.add(new ArrayList<>(path));
            }
            for (int i : graph[start]) {
                dfs(graph, i, path);
            }
            path.remove(path.size() - 1);
        }
    }
}
