package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class No452 {

    @Test
    public void test() {
        new Solution().findMinArrowShots(new int[][]{{1, 4}, {2, 5}, {3, 6}, {4, 7}, {5, 8}});
    }

    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            int count = 1;
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
            int end = points[0][1];
            for (int[] point : points) {
                if (point[0] > end) {
                    count++;
                    end = point[1];
                }
            }
            return count;
        }
    }

}
