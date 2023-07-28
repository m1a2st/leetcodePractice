package leecode.medium;

import java.util.*;

public class No90 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 2};
        List<List<Integer>> lists = solution.subsetsWithDup(a);
        lists.forEach(System.out::println);
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            result.add(new ArrayList<>());
            if (nums.length == 0) return new ArrayList<>(result);
            List<Integer> list = new ArrayList<>();
            recursive(nums, result, list, 0);
            return new ArrayList<>(result);
        }

        private void recursive(int[] nums, Set<List<Integer>> result, List<Integer> list, int start) {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                ArrayList<Integer> ans = new ArrayList<>(list);
                Collections.sort(ans);
                result.add(ans);
                recursive(nums, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static class SolutionNew {

        Set<List<Integer>> result = new HashSet<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            result.add(new ArrayList<>());
            List<Integer> list = new ArrayList<>();
            recursive(nums, list, 0);
            return new ArrayList<>(result);
        }

        private void recursive(int[] nums, List<Integer> list, int start) {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                ArrayList<Integer> ans = new ArrayList<>(list);
                result.add(ans);
                recursive(nums, list, start + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
