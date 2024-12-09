package parctice.leetcode.easy;

public class No1957 {

    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();

            for (int i = 0; i < len; i++) {
                int count = 1;
                char c = s.charAt(i);
                sb.append(c);
                while (i + 1 < len && s.charAt(i + 1) == c) {
                    count++;
                    if (count < 3) {
                        sb.append(c);
                    }
                    i++;
                }
            }
            return sb.toString();
        }
    }
}
