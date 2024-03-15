package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No205 {

    class Solution {
        Map<Character, Character> maps = new HashMap<>();

        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                if (!maps.containsKey(sChar) && checkEntry(tChar)) {
                    maps.put(sChar, tChar);
                } else {
                    if (maps.get(sChar) == null || tChar != maps.get(sChar)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean checkEntry(Character c) {
            return maps.entrySet().stream().allMatch(entry -> entry.getValue() != c);
        }
    }

    class SolutionA {
        public boolean isIsomorphic(String s, String t) {
            char[] l = s.toCharArray();
            char[] k = t.toCharArray();
            int[] arr = new int[256];
            int[] brr = new int[256];


            for (int i = 0; i < l.length; i++) {
                if (arr[l[i]] == 0 && brr[k[i]] == 0) {
                    arr[l[i]] = k[i];
                    brr[k[i]] = 1;
                }
            }
            for (int i = 0; i < l.length; i++) {
                if (arr[l[i]] != k[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
