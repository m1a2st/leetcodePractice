package parctice.leetcode.easy;

public class No1832 {

    class Solution {
        public boolean checkIfPangram(String sentence) {
            if (sentence.length() < 26) {
                return false;
            }
            int[] cache = new int[26];
            for (char c : sentence.toCharArray()) {
                ++cache[c - 'a'];
            }
            for (int i : cache) {
                if (i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
