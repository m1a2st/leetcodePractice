package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No119 {

    @Test
    public void test() {
        new Solution().getRow(5).forEach(System.out::println);
    }


    class Solution {
        public List<Integer> getRow(int rowIndex) {
            int realIndex = rowIndex + 1;
            List<Integer> ans = new ArrayList<>();
            int[][] dp = new int[realIndex][realIndex];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < realIndex; i++) {
                for (int j = 1; j < realIndex; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            for (int i : dp[realIndex - 1]) {
                ans.add(i);
            }
            return ans;
        }
    }
}
