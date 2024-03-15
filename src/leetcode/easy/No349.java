package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class No349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for (int i : nums1) {
                s1.add(i);
            }
            for (int i : nums2) {
                if (s1.contains(i)) {
                    s2.add(i);
                }
            }
            int[] ans = new int[s2.size()];
            int index = 0;
            for (Integer i : s2) {
                ans[index] = i;
                ++index;
            }
            return ans;
        }
    }
}
