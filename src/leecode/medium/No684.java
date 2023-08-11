package leecode.medium;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/9
 * @Version v1.0
 */
public class No684 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantConnection = solution.findRedundantConnection(edges);
        System.out.println(redundantConnection[0] + " " + redundantConnection[1]);
    }

    class UnionFind {

        private final int[] id;
        private final int[] rank;

        public UnionFind(int n) {
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
        }

        public boolean unionByRank(int u, int v) {
            final int i = find(u);
            final int j = find(v);
            if (i == j)
                return false;
            if (rank[i] < rank[j]) {
                id[i] = j;
            } else if (rank[i] > rank[j]) {
                id[j] = i;
            } else {
                id[i] = j;
                ++rank[j];
            }
            return true;
        }

        private int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }
    }

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UnionFind uf = new UnionFind(edges.length + 1);

            for (int[] edge : edges)
                if (!uf.unionByRank(edge[0], edge[1]))
                    return edge;

            throw new IllegalArgumentException();
        }
    }
}
