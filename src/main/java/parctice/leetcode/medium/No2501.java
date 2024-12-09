package main.java.parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No2501 {

    public class Solution {
        public int longestSquareStreak(int[] nums) {
            // 移除重複元素並轉換成 List
            Set<Integer> uniqueNumsSet = new HashSet<>();
            for (int num : nums) {
                uniqueNumsSet.add(num);
            }
            List<Integer> uniqueNums = new ArrayList<>(uniqueNumsSet);

            // 以降序排序
            uniqueNums.sort(Collections.reverseOrder());

            int maxNum = Collections.max(uniqueNums);
            // dp[i] 表示從 i 開始的最長平方序列
            int[] dp = new int[maxNum + 1];

            for (int num : uniqueNums) {
                dp[num] = 1;
                long squaredNum = (long) num * num;
                if (squaredNum <= maxNum) {
                    dp[num] += dp[(int) squaredNum];
                }
            }

            int ans = Arrays.stream(dp).max().orElse(-1);
            return ans < 2 ? -1 : ans;
        }
    }
}
