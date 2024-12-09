package main.java.parctice.leetcode.medium;

public class No3163 {

    class Solution {
        public String compressedString(String word) {
            if (word == null || word.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    count++;
                    if (count == 10) {
                        sb.append(9);
                        sb.append(word.charAt(i - 1));
                        count = 1;
                    }
                } else {
                    sb.append(count);
                    sb.append(word.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(word.charAt(word.length() - 1));
            return sb.toString();
        }
    }
}
