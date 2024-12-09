package main.java.parctice.lintcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class No1604 {

    @Test
    public void test() {
        assertEquals(new Solution().maximumSum(new int[]{51, 71, 17, 42}), 93);
        assertEquals(new Solution().maximumSum(new int[]{42, 33, 60}), 102);
        assertEquals(new Solution().maximumSum(new int[]{51, 32, 43}), -1);
    }

    public class Solution {

        public int maximumSum(int[] a) {
            int[] key = new int[55];
            int ans = -1;
            for (int i : a) {
                int sum = calculateSum(i);
                if (key[sum] == 0) {
                    key[sum] = i;
                } else {
                    ans = Math.max(ans, key[sum] + i);
                }
            }
            return ans;
        }

        private int calculateSum(int i) {
            int sum = 0;
            while (i / 10 != 0) {
                int j = i % 10;
                sum += j;
                i /= 10;
            }
            sum += i;
            return sum;
        }
    }
}
