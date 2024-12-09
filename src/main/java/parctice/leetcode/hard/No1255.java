package main.java.parctice.leetcode.hard;

public class No1255 {

    class Solution {

        int[] count = new int[26];

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            for (final char c : letters) {
                ++count[c - 'a'];
            }
            return dfs(words, 0, score);
        }

        // Returns the maximum score you can get from words[s..n).
        private int dfs(String[] words, int s, int[] score) {
            int ans = 0;
            for (int i = s; i < words.length; ++i) {
                int earned = useWord(words, i, score);
                if (earned > 0) {
                    ans = Math.max(ans, earned + dfs(words, i + 1, score));
                }
                unuseWord(words, i);
            }
            return ans;
        }

        private int useWord(String[] words, int i, int[] score) {
            boolean isValid = true;
            int earned = 0;
            for (char c : words[i].toCharArray()) {
                if (--count[c - 'a'] < 0) {
                    isValid = false;
                }
                earned += score[c - 'a'];
            }
            return isValid ? earned : -1;
        }

        private void unuseWord(String[] words, int i) {
            for (char c : words[i].toCharArray()) {
                ++count[c - 'a'];
            }
        }
    }
}
