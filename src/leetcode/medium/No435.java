package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class No435 {

    @Test
    public void test() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }

    /**
     * 1. 先根據 end 排序，然後遍歷，
     * 2. 如果下一個區間的 start >= 當前區間的 end，代表不重疊，更新當前區間的 end
     * 3. 如果下一個區間的 start < 當前區間的 end，代表重疊，ans + 1
     */
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0)
                return 0;

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

            int ans = 0;
            int currentEnd = intervals[0][1];

            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i][0] >= currentEnd) {
                    currentEnd = intervals[i][1];
                } else {
                    ++ans;
                }
            }

            return ans;
        }
    }
}
