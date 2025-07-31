package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No898 {

    class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> res = new HashSet<>();
            Set<Integer> cur = new HashSet<>();
            for (int num : arr) {
                Set<Integer> next = new HashSet<>();
                next.add(num);
                for (int x : cur) {
                    next.add(x | num);
                }
                cur = next;
                res.addAll(cur);
            }
            return res.size();
        }
    }
}
