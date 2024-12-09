package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No2597 {
    class Solution {

        int ans = 0;

        public int beautifulSubsets(int[] nums, int k) {
            backTracking(nums, 0, k, new ArrayList<>());
            return ans;
        }

        public void backTracking(int[] nums, int start, int k, List<Integer> sub) {
            for (int i = start; i < nums.length; ++i) {
                if (checkingBeautifulSubset(nums[i], sub, k)) {
                    ans++;
                    sub.add(nums[i]);
                    backTracking(nums, i + 1, k, sub);
                    sub.remove(sub.size() - 1);
                }
            }
        }

        public boolean checkingBeautifulSubset(int target, List<Integer> sub, int k) {
            if (sub.isEmpty()) return true;
            for (int i : sub) {
                if (Math.abs(i - target) == k) {
                    return false;
                }
            }
            return true;
        }
    }
}
