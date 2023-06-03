package leecode.medium;

import java.util.*;

public class No438 {

    public static void main(String[] args) {
        var s = "abab";
        var p = "ab";
        Solution.findAnagrams(s, p).forEach(System.out::println);
    }

    static class Solution {
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
}

