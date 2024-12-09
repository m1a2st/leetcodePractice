package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

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

    @Test
    public void test() {
        new SolutionA().isIsomorphic("egg", "add");
    }

    class SolutionA {
        public boolean isIsomorphic(String s, String t) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            int[] sMap = new int[256];
            int[] tMap = new int[256];

            for (int i = 0; i < sArr.length; i++) {
                char sC = sArr[i];
                char tC = tArr[i];
                if (sMap[sC] == 0 && tMap[tC] == 0) {
                    sMap[sC] = tC;
                    tMap[tC] = 1;
                }
            }
            for (int i = 0; i < sArr.length; i++) {
                if (sMap[sArr[i]] != tArr[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
