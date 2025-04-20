package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No69 {

    @Test
    public void test() {
        int i = new Solution().mySqrt(2147483647);
    }

    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            long left = 0, right = (long) x + 1;
            long ans = 0;
            while (left < right) {
                long mid = (right - left) / 2 + left;
                long sqrt = mid * mid;
                if (sqrt == x) {
                    return (int) mid;
                } else if (sqrt > x) {
                    right = mid;
                } else {
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                }
            }
            return (int) ans;
        }
    }
}
