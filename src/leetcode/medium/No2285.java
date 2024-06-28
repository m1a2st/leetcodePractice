package leetcode.medium;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No2285 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.maximumImportance(5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
    }

    class Solution {
        public long maximumImportance(int n, int[][] roads) {
            int[] counter = new int[n + 1];
            long ans = 0;
            for (int[] road : roads) {
                counter[road[0]]++;
                counter[road[1]]++;
            }
            Arrays.sort(counter);
            for (int i = n; i >= 1; i--) {
                ans += (long) counter[i] * i;
            }
            return ans;
        }
    }
}
