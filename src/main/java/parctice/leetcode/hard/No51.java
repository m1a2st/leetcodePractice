package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No51 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }

    class Solution {

        List<List<String>> ans = new ArrayList<>();
        char[][] board;

        public List<List<String>> solveNQueens(int n) {
            board = initBoard(n);
            backtracking(0, n);
            return ans;
        }

        private void backtracking(int start, int n) {
            if (start == n) {
                ArrayList<String> subAns = new ArrayList<>();
                for (char[] chars : board) {
                    subAns.add(new String(chars));
                }
                ans.add(subAns);
                return;
            }
            for (int j = 0; j < n; j++) {
                if (isValid(start, j, n)) {
                    board[start][j] = 'Q';
                    backtracking(start + 1, n);
                    board[start][j] = '.';
                }
            }
        }

        private boolean isValid(int i, int j, int n) {
            for (int k = 0; k < i; k++) {
                if (board[k][j] == 'Q') {
                    return false;
                }
            }
            for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
                if (board[k][l] == 'Q') {
                    return false;
                }
            }
            for (int k = i - 1, l = j + 1; k >= 0 && l < n; k--, l++) {
                if (board[k][l] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        private char[][] initBoard(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            return board;
        }
    }
}
