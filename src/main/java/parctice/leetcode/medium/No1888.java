package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1888 {

    @Test
    public void test1() {
        new Solution().minFlips("111000");
    }

    class Solution {
        public int minFlips(String s) {
            int ans = 999999;
            char flip = '1';

            char[] arr = s.concat(s).toCharArray();
            char[] one_zero = new char[arr.length];
            char[] zero_one = new char[arr.length];

            for (int i = 0; i < one_zero.length; i++) {
                one_zero[i] = flip;
                if (flip == '1') flip = '0';
                else flip = '1';
            }

            flip = '0';
            for (int i = 0; i < zero_one.length; i++) {
                zero_one[i] = flip;
                if (flip == '1') flip = '0';
                else flip = '1';
            }

            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != one_zero[i]) cnt1++;
                if (arr[i] != zero_one[i]) cnt2++;
            }

            ans = Math.min(ans, cnt1);
            ans = Math.min(ans, cnt2);

            int len = s.length();
            // TODO 這一段還是不懂
            for (int i = len; i < arr.length; i++) {
                if (arr[i - len] != one_zero[i - len]) cnt1--;
                if (arr[i] != one_zero[i]) cnt1++;
                ans = Math.min(ans, cnt1);

                if (arr[i - len] != zero_one[i - len]) cnt2--;
                if (arr[i] != zero_one[i]) cnt2++;
                ans = Math.min(ans, cnt2);
            }


            return ans;
        }
    }
}
