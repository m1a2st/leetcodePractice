package leecode.medium;

import java.util.ArrayList;
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
}
