package parctice.leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/7/30
 * @Version v1.0
 */
public class No79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        String word = "BACD";
        Solution solution = new No79().new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

    class SolutionNew {

        boolean result = false;
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            int x = board.length;
            int y = board[0].length;
            visited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    findTheWord(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
            return result;
        }

        private void findTheWord(char[][] board, String word, int x, int y, int start) {
            if (x < 0 || y < 0 || x == board.length || y == board[0].length) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            if (board[x][y] != word.charAt(start)) {
                return;
            }

            visited[x][y] = true;

            if (start == word.length() - 1) {
                result = true;
                return;
            }

            findTheWord(board, word, x + 1, y, start + 1);
            findTheWord(board, word, x, y + 1, start + 1);
            findTheWord(board, word, x - 1, y, start + 1);
            findTheWord(board, word, x, y - 1, start + 1);

            visited[x][y] = false;
        }
    }

    class Solution {

        boolean result = false;

        public boolean exist(char[][] board, String word) {
            int x = board.length;
            int y = board[0].length;
            boolean[][] visited = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    findTheResult(board, visited, i, j, 0, word);
                    if (result) {
                        return true;
                    }
                }
            }
            return result;
        }

        private void findTheResult(char[][] board,
                                   boolean[][] visited,
                                   int x,
                                   int y,
                                   int start,
                                   String word) {
            // xy 要在邊界內
            if (x < 0 || y < 0 || x == board.length || y == board[0].length) {
                return;
            }

            // 已經走過了
            if (visited[x][y]) {
                return;
            }

            if (board[x][y] != word.charAt(start)) {
                return;
            }

            visited[x][y] = true;

            if (word.length() - 1 == start) {
                // The entire word has been matched
                result = true;
                return;
            }

            findTheResult(board, visited, x + 1, y, start + 1, word);
            findTheResult(board, visited, x, y + 1, start + 1, word);
            findTheResult(board, visited, x - 1, y, start + 1, word);
            findTheResult(board, visited, x, y - 1, start + 1, word);

            // Backtrack
            visited[x][y] = false;
        }
    }
}
