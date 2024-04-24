package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class No1137 {

    class Solution {
        public int tribonacci(int n) {
            int i = 0;
            int j = 1;
            int k = 1;
            if (n == 0) return i;
            if (n == 1 || n == 2) return j;
            int ans = 0;
            for (int l = 3; l < n; l++) {
                ans = i + j + k;
                i = j;
                j = k;
                k = ans;
            }
            return ans;
        }
    }
}
