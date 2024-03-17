package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No57 {

    @Test
    public void test() {
        new Solution().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }


    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();
            int i = 0;

            // 此區段還未進入到 newInterval 的範圍，所以直接加入 result
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }
            // 此區段還在 newInterval 的範圍內，所以合併，合併的方式是取最小的 start 和最大的 end
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            result.add(newInterval);
            // 此區段已經超出 newInterval 的範圍，所以直接加入 result
            while (i < intervals.length) {
                result.add(intervals[i]);
                i++;
            }

            int[][] arr = new int[result.size()][2];
            for (int j = 0; j < result.size(); j++) {
                arr[j] = result.get(j);
            }

            return arr;
        }
    }
}
