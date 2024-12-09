package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No201 {

    @Test
    public void test() {
        new Solution().rangeBitwiseAnd(5, 7);
    }


    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shiftBits = 0;

            while (m != n) {
                m >>= 1;
                n >>= 1;
                ++shiftBits;
            }

            return m << shiftBits;
        }
    }
}
