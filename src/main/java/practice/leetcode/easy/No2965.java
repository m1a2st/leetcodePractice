package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class No2965 {

    @Test
    void test() {
        int[][] grid = new int[][]{{1, 3}, {2, 4}};
        int[] result = new Solution().findMissingAndRepeatedValues(grid);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int[] result = new int[2];
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            int max = 0;
            int j = 1;
            for (int[] ints : grid) {
                for (int i : ints) {
                    if (set.contains(i)) {
                        result[0] = i;
                    } else {
                        set.add(i);
                        sum += i;
                    }
                    max = max + j++;
                }
            }
            result[1] = max - sum;
            return result;
        }
    }
}
