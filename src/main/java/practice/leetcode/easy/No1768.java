package practice.leetcode.easy;

public class No1768 {

    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int wl = word1.length();
            int wl2 = word2.length();
            int index = 0;
            while (index < wl && index < wl2) {
                sb.append(word1.charAt(index));
                sb.append(word2.charAt(index));
                index++;
            }
            while (index < wl) {
                sb.append(word1.charAt(index));
                index++;
            }
            while (index < wl2) {
                sb.append(word2.charAt(index));
                index++;
            }
            return sb.toString();
        }
    }
}
