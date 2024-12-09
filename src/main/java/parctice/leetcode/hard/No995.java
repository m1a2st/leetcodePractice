package main.java.parctice.leetcode.hard;

public class No995 {

    class Solution {
        public int minKBitFlips(int[] nums, int k) {
            int len = nums.length;
            int[] diff = new int[len + 1];
            int ans = 0;
            int revCnt = 0;
            for (int i = 0; i < len; i++) {
                revCnt += diff[i];
                if ((nums[i] + revCnt) % 2 == 0) {
                    if (i + k > len) {
                        return -1;
                    }
                    ++ans;
                    ++revCnt;
                    ++diff[i + k];
                }
            }
            return ans;
        }
    }
}
