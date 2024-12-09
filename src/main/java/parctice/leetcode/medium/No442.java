package main.java.parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No442 {

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            Set<Integer> ans = new HashSet<>();
            int[] visited = new int[100001];
            for (int num : nums) {
                visited[num]++;
                if (visited[num] > 1) {
                    ans.add(num);
                }
            }
            return new ArrayList<>(ans);
        }
    }

    class SolutionBest {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();

            for (int num : nums) {
                nums[Math.abs(num) - 1] *= -1;
                if (nums[Math.abs(num) - 1] > 0) {
                    ans.add(Math.abs(num));
                }
            }

            return ans;
        }
    }
}
