package leecode.medium;

import java.util.*;

public class No18 {

    class Solution {

        Set<List<Integer>> ans = new HashSet<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) {
                return new ArrayList<>(ans);
            }
            Arrays.sort(nums);
            backtrace(nums, target, 0, 0, new ArrayList<>());
            return new ArrayList<>(ans);
        }

        private void backtrace(int[] nums, int target, int count, int start, List<Integer> subAns) {
            if (count == 4) {
                if (target == 0) {
                    ans.add(new ArrayList<>(subAns));
                }
                return;
            }
            for (int j = start; j < nums.length; j++) {
                subAns.add(nums[j]);
                backtrace(nums, target - nums[j], count + 1, j + 1, subAns);
                subAns.remove(subAns.size() - 1);
            }
        }
    }
}
