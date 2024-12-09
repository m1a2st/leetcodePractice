package main.java.parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56 {

    /**
     * 1. 對起始時間做排序
     * 2. 先設定 start 與 end 為第一個區間的起始與結束時間
     * 3. 檢查第二個區間的起始時間是否小於等於前一個區間的結束時間
     * 4. 若有重疊則將 end 設為兩者最大值
     * 5. 若無重疊則將區間加入 cache 並更新 start 與 end
     * 6. 最後將最後一個區間加入 cache
     * 7. 將 cache 轉為陣列回傳
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
            List<int[]> cache = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (end >= intervals[i][0]) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    cache.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            cache.add(new int[]{start, end});
            return cache.toArray(new int[cache.size()][2]);
        }
    }
}
