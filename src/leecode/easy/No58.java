package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No58 {
    class Solution {
        public int lengthOfLastWord(String s) {
            String[] s1 = s.trim().split(" ");
            return s1[s1.length - 1].length();
        }
    }
}
