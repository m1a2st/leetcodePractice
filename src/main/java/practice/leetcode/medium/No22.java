package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/6/15
 * @Version v1.0
 */
public class No22 {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, new StringBuilder());
            return ans;
        }

        private void dfs(int left, int right, StringBuilder sb) {
            if (left == 0 && right == 0) {
                ans.add(sb.toString());
                return;
            }
            if (left > 0) {
                sb.append("(");
                dfs(left - 1, right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right > left) {
                sb.append(")");
                dfs(left, right - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
