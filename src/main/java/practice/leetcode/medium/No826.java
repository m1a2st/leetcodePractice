package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class No826 {

    @Test
    void test() {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        System.out.println(new Solution().maxProfitAssignment(difficulty, profit, worker));
    }

    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int len = difficulty.length;
            int[][] jobs = new int[len][2];
            for (int i = 0; i < len; i++) {
                jobs[i] = new int[]{difficulty[i], profit[i]};
            }
            Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
            Arrays.sort(worker);
            int ans = 0;
            int index = 0;
            int max = 0;
            for (int w : worker) {
                while (index < len && jobs[index][0] <= w) {
                    max = Math.max(max, jobs[index][1]);
                    index++;
                }
                ans += max;
            }
            return ans;
        }
    }
}
