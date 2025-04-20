package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class No310 {

    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 0 || edges.length == 0) {
                return new ArrayList<>(List.of(0));
            }

            List<Integer> ans = new ArrayList<>();
            // 創造一個鄰接矩陣
            Map<Integer, Set<Integer>> graph = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                graph.put(i, new HashSet<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                // 因為是無向圖
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                int label = entry.getKey();
                Set<Integer> children = entry.getValue();
                // 找出所有的葉子節點，因為葉子節點是指只有一個相鄰節點的節點，
                // 它們是最容易識別且需要處理的節點類型。在找到所有葉子節點後，
                // 我們可以將它們從圖中移除，因為它們不可能是最小高度樹的根節點。
                if (children.size() == 1) {
                    ans.add(label);
                }
            }
            // 通過這個 while 迴圈，我們不斷地從圖中移除葉子節點，直到剩下的節點數目為 1或 2。
            // 這樣一來，最後答案列表中所包含的節點就是可能的最小高度樹的根節點或根節點的集合
            while (n > 2) {
                // 確定還有多少節點需要處理
                n -= ans.size();
                List<Integer> nextLeaves = new ArrayList<>();
                for (int leaf : ans) {
                    int u = graph.get(leaf).iterator().next();
                    graph.get(u).remove(leaf);
                    // 如果相鄰節點 u 變成了新的葉子節點，即其相鄰節點只有一個，
                    // 則將其添加到新的列表 nextLeaves 中。
                    if (graph.get(u).size() == 1) {
                        nextLeaves.add(u);
                    }
                }
                ans = nextLeaves;
            }

            return ans;
        }
    }
}
