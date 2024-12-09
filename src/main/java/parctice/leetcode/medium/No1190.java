package main.java.parctice.leetcode.medium;

import java.util.Stack;

public class No1190 {
    
    class Solution {
        public String reverseParentheses(String s) {
            Stack<Integer> bucketIndex = new Stack<>();
            int len = s.length();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    bucketIndex.push(i);
                }
                if (c == ')') {
                    Integer index = bucketIndex.pop();
                    s = reverseString(s, index, i);
                    i -= 2;
                }
            }
            return s;
        }

        private String reverseString(String s, Integer index, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, index);
            sb.append(new StringBuilder(s.substring(index + 1, i)).reverse());
            sb.append(s.substring(i + 1));
            return sb.toString();
        }
    }
}
