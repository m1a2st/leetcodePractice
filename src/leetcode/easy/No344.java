package leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/3/21
 * @Version v1.0
 */
public class No344 {

    public static void main(String[] args) {
        Solution.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    static class Solution {
        public static void reverseString(char[] s) {
            int index = s.length - 1;
            for (int i = 0; i < (s.length / 2); i++, index--) {
                swap(s, i, index);
            }
        }

        private static void swap(char[] s, int i, int length) {
            char c = s[i];
            s[i] = s[length];
            s[length] = c;
        }
    }
}
