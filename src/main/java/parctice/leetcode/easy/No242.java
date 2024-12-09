package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/3
 * @Version v1.0
 */
public class No242 {

    class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                counter[c - 'a']--;
                if (counter[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagramOld(String s, String t) {
            Map<String, Integer> map = new HashMap<>();
            String[] ss = s.split("");
            for (String s1 : ss) {
                if (map.containsKey(s1)) {
                    map.put(s1, map.get(s1) + 1);
                } else {
                    map.put(s1, 1);
                }
            }
            String[] ts = t.split("");
            for (String t1 : ts) {
                if (map.containsKey(t1)) {
                    map.put(t1, map.get(t1) - 1);
                } else {
                    return false;
                }
            }
            return map.values().stream().allMatch(integer -> integer == 0);
        }
    }

    class SolutionNew {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] arr = new char[26];
            char a = 'a';
            for (char c : s.toCharArray()) {
                arr[c - a]++;
            }
            for (char c : t.toCharArray()) {
                arr[c - a]--;
                if (arr[c - a] == 65535) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String s = "anagram", t = "nagaram";
        assertTrue(solution.isAnagram(s, t));
    }

    @Test
    public void test2() {
        SolutionNew solution = new SolutionNew();
        String s = "rat", t = "car";
        assertFalse(solution.isAnagram(s, t));
    }
}
