package leetcode.easy;

import java.util.*;

public class No1207 {

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> ans = new HashMap<>();
            for (int i : arr) {
                ans.merge(i, 1, Integer::sum);
            }
            Set<Integer> set = new HashSet<>(ans.values());
            return ans.size() == set.size();
        }
    }
}
