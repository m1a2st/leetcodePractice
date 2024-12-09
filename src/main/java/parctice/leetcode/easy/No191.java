package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/8/15
 * @Version v1.0
 */
public class No191 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
    }

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                // n & 1 == 1 代表最後一位是1
                res += n & 1;
                n = n >> 1;
            }
            return res;
        }
    }
}
