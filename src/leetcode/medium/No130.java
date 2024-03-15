package leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/8/6
 * @Version v1.0
 */
public class No130 {

    class Solution {

        public void solve(char[][] board) {
            int x = board.length;
            int y = board[0].length;
            boolean[][] visited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                dfs(board, i, 0, visited);
                dfs(board, i, y - 1, visited);
            }
            for (int j = 0; j < y; j++) {
                dfs(board, 0, j, visited);
                dfs(board, x - 1, j, visited);
            }

            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++) {
                    if(visited[i][j]){
                        board[i][j] = '0';
                    }else{
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j, boolean[][] visited) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X') return;

            if(visited[i][j]){
                return;
            }
            visited[i][j] = true;

            dfs(board, i + 1, j, visited);
            dfs(board, i, j + 1, visited);
            dfs(board, i - 1, j, visited);
            dfs(board, i, j - 1, visited);
        }
    }
}
