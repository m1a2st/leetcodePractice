package leecode.medium;

import java.sql.Array;
import java.util.*;

public class No438 {

    public static void main(String[] args) {
        var s = "abab";
        var p = "ab";
        Solution.findAnagrams(s, p).forEach(System.out::println);
    }

    static class SolutionOld {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int pLength = p.length();
            if (s.length() < pLength) {
                return res;
            }
            for (int i = 0; i <= s.length() - pLength; i++) {
                String substring = s.substring(i, i + pLength);
                if (compare(p, substring)) {
                    res.add(i);
                }
            }
            return res;
        }

        public static boolean compare(String s1, String s2) {
            byte[] b1 = s1.getBytes();
            byte[] b2 = s2.getBytes();
            int[] bCount = new int[256];
            for (byte b : b1) bCount[b - 'a']++;
            for (byte b : b2) bCount[b - 'b']--;
            for (int i = 0; i < 256 - 'a'; i++) {
                if (bCount[i] != 0)
                    return false;
            }
            return true;
        }
    }

    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> res = new ArrayList<>();
            int pLen = p.length();

            for (int i = 0; i <= s.length() - pLen; i++) {
                String sub = s.substring(i, i + pLen);
                if (compare(sub, p)) {
                    res.add(i);
                }
            }

            return res;
        }

        public static boolean compare(String s1, String s2) {
            int[] s1Arr = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                s1Arr[c1 - 'a']++;
                s1Arr[c2 - 'a']--;
            }
            for (int i : s1Arr) {
                if(i != 0) return false;
            }
            return true;
        }
    }
}

