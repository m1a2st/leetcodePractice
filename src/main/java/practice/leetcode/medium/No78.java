package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No78 {

    @Test
    public void test() {
        int[] a = {1, 2, 3};
        new Solution().subsets(a).forEach(System.out::println);
    }


    class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            ans.add(new ArrayList<>());
            backTracking(nums, 0, new ArrayList<>());
            return ans;
        }

        private void backTracking(int[] nums, int i, List<Integer> sub) {
            for (int j = i; j < nums.length; j++) {
                sub.add(nums[j]);
                ans.add(new ArrayList<>(sub));
                backTracking(nums, j + 1, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
