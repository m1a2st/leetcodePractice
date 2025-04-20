package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No216 {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum3(9, 45);
        System.out.println(lists);
    }

    class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(k, n, 1, new ArrayList<>());
            return ans;
        }

        private void dfs(int times, int target, int i, ArrayList<Integer> sub) {
            if (sub.size() == times && target == 0) {
                ans.add(new ArrayList<>(sub));
                return;
            } else if (sub.size() == times || target < 0) {
                return;
            }
            for (int j = i; j <= 9; j++) {
                sub.add(j);
                dfs(times, target - j, j + 1, new ArrayList<>(sub));
                sub.remove(sub.size() - 1);
            }
        }
    }

    class SolutionFast {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backTracing(k, n, 1, 0);
            return result;
        }

        public void backTracing(int k, int n, int startIndex, int sum) {
            if (path.size() == k) {
                if (sum == n) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
                sum += i;
                path.add(i);
                backTracing(k, n, i + 1, sum);
                sum -= i;
                path.removeLast();
            }
        }
    }
}
