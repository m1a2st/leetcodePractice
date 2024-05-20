package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No2966 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] ans = solution.divideArray(nums, k);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int n = nums.length / 3;
            int[][] ans = new int[n][3];
            Arrays.sort(nums);

            // 检查是否满足条件
            for (int i = 0; i < n; i++) {
                System.arraycopy(nums, i * 3 + 0, ans[i], 0, 3);
                if (ans[i][2] - ans[i][0] > k) {
                    return new int[][]{};
                }
            }
            return ans;
        }
    }

    class SolutionNew {
        public int[][] divideArray(int[] nums, int k) {
            int n = nums.length / 3;
            int[][] ans = new int[n][3];
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                System.arraycopy(nums, 3 * i + 0, ans[i], 0, 3);
                if (ans[i][2] - ans[i][0] > k) {
                    return new int[][]{};
                }
            }
            return ans;
        }
    }
}
