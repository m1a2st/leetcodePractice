package main.java.parctice.leetcode.medium;

public class No2109 {

    class Solution {
        public String addSpaces(String s, int[] spaces) {
            int index = 0;
            StringBuilder sb = new StringBuilder();
            if (spaces[index] == 0) {
                sb.append(" ");
                index++;
            }
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (index < spaces.length && i == spaces[index] - 1) {
                    sb.append(" ");
                    index++;
                }
            }
            return sb.toString();
        }
    }
}
