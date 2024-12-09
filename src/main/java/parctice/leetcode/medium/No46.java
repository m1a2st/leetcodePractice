package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
        int[] a = {1, 2, 3};
        solution.permute(a);
    }

    class Solution {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) return result;
            used = new boolean[nums.length];
            recursive(nums, new ArrayList<>());
            return result;
        }

        private void recursive(int[] nums, List<Integer> list) {
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
                recursive(nums, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    class SolutionNew {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                recursive(nums, i, new ArrayList<>());
            }
            return ans;
        }

        private void recursive(int[] nums, int start, ArrayList<Integer> subArr) {
            subArr.add(nums[start]);
            if (nums.length == 1) {
                ans.add(new ArrayList<>(subArr));
                subArr.remove(subArr.size() - 1);
                return;
            }
            int[] cache = copy(nums, start);
            for (int i = 0; i < cache.length; i++) {
                recursive(cache, i, subArr);
            }
            subArr.remove(subArr.size() - 1);
        }

        private int[] copy(int[] nums, int index) {
            if (nums.length == 0) {
                return new int[0];
            }
            int[] res = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i != index) {
                    res[j++] = nums[i];
                }
            }
            return res;
        }
    }
}
