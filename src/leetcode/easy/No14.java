package leetcode.easy;

public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            int index = 0;
            while ((index < prefix.length() && index < str.length() && prefix.charAt(index) == str.charAt(index))) {
                index++;
            }
            prefix = prefix.substring(0, index);
        }
        if (prefix.length() > 0) {
            return prefix;
        }
        return "";
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int index = 0;
                while (index < prefix.length() &&
                        index < strs[i].length() &&
                        prefix.charAt(index) == strs[i].charAt(index)) {
                    index++;
                }
                prefix = prefix.substring(0, index);
            }
            if (prefix.length() > 0) {
                return prefix;
            }
            return "";
        }
    }

    class SolutionNew {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int minLength = Integer.MAX_VALUE; // Initialize to a large value
            int size = strs.length;

            // Find the minimum length among all strings
            for (String s : strs) {
                minLength = Math.min(minLength, s.length());
            }

            StringBuilder commonPrefix = new StringBuilder();

            // Compare characters at each position among all strings
            for (int i = 0; i < minLength; i++) {
                char currentChar = strs[0].charAt(i);
                for (int j = 1; j < size; j++) {
                    if (strs[j].charAt(i) != currentChar) {
                        return commonPrefix.toString();
                    }
                }
                commonPrefix.append(currentChar);
            }

            return commonPrefix.toString();
        }
    }
}
