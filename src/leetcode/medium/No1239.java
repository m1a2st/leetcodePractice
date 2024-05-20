package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1239 {

    class Solution {
        public int maxLength(List<String> arr) {
            int max = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (!allUniq(arr.get(i))) {
                    arr.remove(i);
                }
            }
            for (int i = 0; i < arr.size(); i++) {
                if (allUniq(arr.get(i))) {
                    StringBuilder str = new StringBuilder(arr.get(i));
                    max = Integer.max(max, helper(arr, i + 1, str));
                }
            }
            return max;
        }

        public int helper(List<String> arr, int i, StringBuilder s) {
            int max = s.length();
            for (int j = i; j < arr.size(); j++) {
                if (doesNotMatch(arr.get(j), s) && allUniq(arr.get(j))) {
                    int len = s.length();
                    StringBuilder sb = s.append(arr.get(j));
                    max = Math.max(max, helper(arr, j + 1, sb));
                    s.setLength(len);
                }
            }
            return max;

        }

        boolean doesNotMatch(String s, StringBuilder str) {
            for (int i = 0; i < str.length(); i++) {
                String c = str.charAt(i) + "";
                if (s.contains(c)) {
                    return false;
                }
            }
            return true;
        }

        boolean allUniq(String s) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            return set.size() >= s.length();
        }
    }
}
