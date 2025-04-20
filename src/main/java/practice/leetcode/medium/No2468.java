package practice.leetcode.medium;

public class No2468 {

    class Solution {
        public int appendCharacters(String s, String t) {
            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == t.charAt(index)) {
                    if (++index == t.length()) {
                        return 0;
                    }
                }
            }

            return t.length() - index;
        }
    }
}
