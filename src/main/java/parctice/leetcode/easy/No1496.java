package main.java.parctice.leetcode.easy;

public class No1496 {

    class Solution {
        public boolean isPathCrossing(String path) {
            int x = 100, y = 100;
            boolean[][] visited = new boolean[200][200];
            visited[x][y] = true;
            for (char c : path.toCharArray()) {
                switch (c) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if (visited[x][y]) {
                    return true;
                }
                visited[x][y] = true;
            }
            return false;
        }
    }
}
