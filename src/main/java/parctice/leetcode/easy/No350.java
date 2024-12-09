package main.java.parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No350 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] cache = new int[1_000];
            for (int num : nums2) {
                ++cache[num];
            }
            List<Integer> list = new ArrayList<>();
            for (int num : nums1) {
                if (cache[num]-- > 0) {
                    list.add(num);
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
