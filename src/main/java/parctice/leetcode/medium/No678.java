package parctice.leetcode.medium;

public class No678 {

    class Solution {
        public boolean checkValidString(String s) {
            // min 表示左括號的最小數量，max 表示左括號的最大數量
            int min = 0, max = 0;
            for (char c : s.toCharArray()) {
                // 如果是左括號，min 和 max 都加 1
                if (c == '(') {
                    min++;
                    max++;
                } else if (c == ')') {
                    // 如果是右括號，min 和 max 都減 1
                    min = Math.max(min - 1, 0);
                    max--;
                    // 如果 max 小於 0，代表左括號太多，返回 false
                    if (max < 0) {
                        return false;
                    }
                    // 如果是星號，min 減 1 因為可以當成空字串或者是左括號，max 加 1 代表當作右括號
                } else if (c == '*') {
                    min = Math.max(min - 1, 0);
                    max++;
                }
            }
            // 如果 min 為 0，代表左括號和右括號數量相等，返回 true
            return min == 0;
        }
    }
}
