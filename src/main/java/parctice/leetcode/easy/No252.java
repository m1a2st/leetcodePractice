package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class No252 {

    @Test
    public void test() {
        System.out.println(new Solution().canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new Solution().canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

    /**
     * 1. 對起始時間做排序
     * 2. 檢查第二個起始時間是否小於前一個結束時間
     * 3. 若有重疊則回傳 false
     */
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i - 1][1] > intervals[i][0]) {
                    return false;
                }
            }
            return true;
        }
    }
}
