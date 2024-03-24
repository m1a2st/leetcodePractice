package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class No797 {

    @Test
    public void test() {

    }

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
}
