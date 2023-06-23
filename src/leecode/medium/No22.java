package leecode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/6/15
 * @Version v1.0
 */
public class No22 {

    class SolutionOld {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> ans = new ArrayList<>();
            dfs(n, n, new StringBuilder(), ans);
            return ans;
        }

        private void dfs(int left, int right, StringBuilder sb, ArrayList<String> ans) {
            if (left == 0 && right == 0) {
                ans.add(sb.toString());
                return;
            }
            if (left > 0) {
                sb.append("(");
                dfs(left - 1, right, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (left < right) {
                sb.append(")");
                dfs(left, right - 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            dfs(n, n, new StringBuilder(), ans);
            return ans;
        }

        private void dfs(int l, int r, StringBuilder sb, List<String> ans) {
            if (l == 0 && r == 0) {
                ans.add(sb.toString());
                return;
            }
            if (l > 0) {
                sb.append("(");
                dfs(l - 1, r, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r > l) {
                sb.append(")");
                dfs(l, r - 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);

    }
}
