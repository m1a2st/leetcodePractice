package practice.leetcode.easy;

public class No2011 {

    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int ans = 0;
            for (String s : operations) {
                if (s.contains("++")) {
                    ans++;
                } else {
                    ans--;
                }
            }
            return ans;
        }
    }
}
