package practice.leetcode.easy;

public class No2582 {

    class Solution {
        public int passThePillow(int n, int time) {
            int pass = n - 1;
            boolean reverse = ((time / pass) & 1) == 1;
            int lastPass = time % pass;
            return reverse ? n - lastPass : lastPass + 1;
        }
    }
}
