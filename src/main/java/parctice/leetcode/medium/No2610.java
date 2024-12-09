package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No2610 {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
        System.out.println(ans);
    }


    class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            // The number of rows we need equals the maximum frequency.
            List<List<Integer>> ans = new ArrayList<>();
            int[] count = new int[nums.length + 1];

            for (int num : nums) {
                // Construct `ans` on demand.
                if (++count[num] > ans.size()) {
                    ans.add(new ArrayList<>());
                }
                ans.get(count[num] - 1).add(num);
            }

            return ans;
        }
    }
}
