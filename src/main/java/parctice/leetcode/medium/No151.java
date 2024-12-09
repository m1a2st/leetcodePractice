package main.java.parctice.leetcode.medium;

public class No151 {

    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] split = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                sb.append(split[i]).append(" ");
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
}
