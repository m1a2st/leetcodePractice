package leecode.medium;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/19
 * @Version v1.0
 */
public class No371 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.getSum(2, 2));
    }

    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int carry = a & b; // 110 001 -> 000
                a ^= b;
                b = carry << 1;
            }
            return a;
        }
    }
}
