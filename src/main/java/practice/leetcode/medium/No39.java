package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No39 {

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int target = 8;
        SolutionNew solution = new SolutionNew();
        solution.combinationSum(a, target).forEach(s -> {
            s.forEach(System.out::print);
            System.out.println();
        });
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (candidates == null) return result;
            List<Integer> list = new ArrayList<>();
            recursive(candidates, result, list, target, 0);
            return result;
        }

        private void recursive(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int start) {
            if (target < 0) return;
            if (target == 0) {
                result.add(new ArrayList<>(list)); //
                return;
            }
            for (int p = start; p < candidates.length; p++) {
                list.add(candidates[p]); //添加節點到路徑
                recursive(candidates, result, list, target - candidates[p], p); //在已有路径基础上继续查找更新权值后后的路径，因为有自环，所以还是从自身节点开始搜索
                list.remove(list.size() - 1); //当从当前节点的所有路径都搜索完毕后，将其剔除，之后重新搜索从下一个节点开始的所有路径
            }
        }
    }

    static class SolutionNew {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> list = new ArrayList<>();
            recursive(candidates, list, target, 0);
            return result;
        }

        private void recursive(int[] candidates, List<Integer> list, int target, int start) {
            // 跳出迴圈
            if (target < 0) return;
            // 寫入解答
            if (target == 0) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                // 操作
                list.add(candidates[i]);
                // 遞迴
                recursive(candidates, list, target - candidates[i], i);
                // 退回
                list.remove(list.size() - 1);
            }
        }
    }
}
