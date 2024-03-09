package leecode.data_structure.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AdjustMatrixTree {

    @Test
    public void test() {
        Practice practice = new Practice();
        practice.adj[0][1] = true;
        practice.adj[0][2] = true;
        practice.adj[1][3] = true;
        practice.adj[1][4] = true;
        practice.adj[2][5] = true;
        practice.adj[2][6] = true;
        practice.adj[3][7] = true;
        practice.adj[3][8] = true;
        practice.parent[0] = -1;
        practice.dfs(0);
        System.out.println(Arrays.toString(practice.parent));
    }

    class Practice{
        boolean[][] adj = new boolean[9][9];
        int[] parent = new int[9];

        public void dfs(int x) {
            for (int y = 0; y < 9; y++) {
                if (adj[x][y] && y != parent[x]) {
                    parent[y] = x;
                    dfs(y);
                }
            }
        }
    }
}
