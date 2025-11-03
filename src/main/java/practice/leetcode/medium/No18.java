package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    class SolutionBest {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            nSum(nums, 4, target, 0, nums.length - 1, new ArrayList<>(), ans);
            return ans;
        }

        // Finds n numbers add up to the target in [l, r].
        private void nSum(int[] nums, long n, long target, int l, int r,
                          List<Integer> path, List<List<Integer>> ans) {
            if (r - l + 1 < n || target < nums[l] * n || target > nums[r] * n)
                return;
            if (n == 2) {
                // Similar to the sub procedure in 15. 3Sum
                while (l < r) {
                    final int sum = nums[l] + nums[r];
                    if (sum == target) {
                        path.add(nums[l]);
                        path.add(nums[r]);
                        ans.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                        ++l;
                        --r;
                        while (l < r && nums[l] == nums[l - 1])
                            ++l;
                        while (l < r && nums[r] == nums[r + 1])
                            --r;
                    } else if (sum < target) {
                        ++l;
                    } else {
                        --r;
                    }
                }
                return;
            }

            for (int i = l; i <= r; ++i) {
                if (i > l && nums[i] == nums[i - 1])
                    continue;
                path.add(nums[i]);
                nSum(nums, n - 1, target - nums[i], i + 1, r, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
