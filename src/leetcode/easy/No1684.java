package leetcode.easy;

public class No1684 {

    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int[] cache = new int[26];
            for (char c : allowed.toCharArray()) {
                cache[c - 'a'] = 1;
            }
            int res = 0;
            for (String word : words) {
                boolean flag = true;
                for (char c : word.toCharArray()) {
                    if (cache[c - 'a'] < 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    res++;
            }
            return res;
        }
    }
}
