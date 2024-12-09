package main.java.parctice.leetcode.medium;

public class No1813 {

    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            // swap the string[] which has less length, so that s1 is always the shorter one
            if (s1.length > s2.length) {
                String[] temp = s1;
                s1 = s2;
                s2 = temp;
            }
            
            int i = 0;
            while (i < s1.length && s1[i].equals(s2[i])) {
                i++;
            }
            int j = s1.length - 1;
            int k = s2.length - 1;
            while (j >= 0 && k >= 0 && s1[j].equals(s2[k])) {
                j--;
                k--;
            }
            return i > j;
        }
    }
}
