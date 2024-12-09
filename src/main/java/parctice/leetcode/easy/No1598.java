package parctice.leetcode.easy;

public class No1598 {

    class Solution {
        public int minOperations(String[] logs) {
            int ans = 0;
            for (String log : logs) {
                if (log.contains("..") && ans != 0) {
                    ans--;
                } else if (log.contains(".")) {

                } else {
                    ans++;
                }
            }
            return ans;
        }
    }
}
