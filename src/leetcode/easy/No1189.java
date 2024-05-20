package leetcode.easy;

public class No1189 {

    class Solution {
        public int maxNumberOfBalloons(String text) {
            char[] balloon = new char[26];
            char[] ca = text.toCharArray();
            for (char c : ca) {
                balloon[c - 'a']++;
            }
            int res = Integer.MAX_VALUE;
            res = Math.min(res, balloon['b' - 'a']);
            res = Math.min(res, balloon[0]);
            res = Math.min(res, balloon['l' - 'a'] / 2);
            res = Math.min(res, balloon['o' - 'a'] / 2);
            res = Math.min(res, balloon['n' - 'a']);
            return res;
        }
    }
}
