package practice.leetcode.medium;

import java.util.ArrayList;

public class No1992 {

    class Solution {

        ArrayList<int[]> cache = new ArrayList<>();

        public int[][] findFarmland(int[][] land) {
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 1) {
                        int[] point = new int[4];
                        point[0] = i;
                        point[1] = j;
                        dfs(land, i, j, point);
                        cache.add(point);
                    }
                }
            }
            return cache.toArray(new int[cache.size()][]);
        }

        private void dfs(int[][] land, int i, int j, int[] temp) {
            if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0) {
                return;
            }
            land[i][j] = 0;
            temp[2] = Math.max(temp[2], i);
            temp[3] = Math.max(temp[3], j);
            dfs(land, i + 1, j, temp);
            dfs(land, i - 1, j, temp);
            dfs(land, i, j + 1, temp);
            dfs(land, i, j - 1, temp);
        }
    }
}
