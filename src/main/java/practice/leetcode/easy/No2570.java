package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class No2570 {

    @Test
    void test() {
        Solution solution = new Solution();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] ans = solution.mergeArrays(nums1, nums2);
        for (int[] ints : ans) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int[] ints : nums1) {
                map.merge(ints[0], ints[1], Integer::sum);
            }
            for (int[] ints : nums2) {
                map.merge(ints[0], ints[1], Integer::sum);
            }
            int[][] ans = new int[map.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans[i][0] = entry.getKey();
                ans[i++][1] = entry.getValue();
            }
            return ans;
        }
    }
}
