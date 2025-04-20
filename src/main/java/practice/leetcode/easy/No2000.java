package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No2000 {

    @Test
    public void test() {
        System.out.println(new Solution().reversePrefix("abcdefg", 'd'));
        System.out.println(new Solution().reversePrefix("abcdefg", 'z'));
    }

    class Solution {
        public String reversePrefix(String word, char ch) {
            int i = word.indexOf(ch);
            if (i == -1) {
                return word;
            }
            StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
            return sb.reverse().append(word.substring(i + 1)).toString();
        }
    }
}
