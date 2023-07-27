package leecode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No46 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3};
        solution.permute(a);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) return result;
            List<Integer> list = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            recursive(nums, result, list, used);
            return result;
        }

        private void recursive(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                recursive(nums, result, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    static class SolutionNew {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            recursive(nums, list);
            return result;
        }

        private void recursive(int[] nums, List<Integer> list) {
            // 終止條件
            if (nums.length == list.size()) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int num : nums) {
                if (!list.contains(num)) {
                    // 前置動作
                    list.add(num);
                    // 遞迴
                    recursive(nums, list);
                    // 後置動作
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
