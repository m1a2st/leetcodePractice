package practice.leetcode.easy;

public class No1323 {

    class Solution {
        public int maximum69Number(int num) {
            char[] ans = String.valueOf(num).toCharArray();

            for (int i = 0; i < ans.length; ++i)
                if (ans[i] == '6') {
                    ans[i] = '9';
                    break;
                }

            return Integer.parseInt(String.valueOf(ans));
        }
    }
}
