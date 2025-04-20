package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No997 {

    @Test
    public void test() {
        System.out.println(new Solution().findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] cache = new int[n];
            for (int[] relationship : trust) {
                int truster = relationship[0] - 1;
                int trustee = relationship[1] - 1;
                cache[truster] = -1;
                cache[trustee]++;
            }
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] == n - 1) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
