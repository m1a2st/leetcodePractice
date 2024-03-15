package leetcode.easy;

import org.junit.Test;

public class No441 {

    @Test
    public void test(){
        System.out.println(Math.sqrt(4));
    }

    class Solution {
        public int arrangeCoins(int n) {
            int step = 0;
            while (n > step) {
                step++;
                n -= step;
            }
            return step;
        }
    }

    class SolutionNew {
        public int arrangeCoins(long n) {
            return (int) (-1 + Math.sqrt(8 * n + 1)) / 2;
        }
    }

}
