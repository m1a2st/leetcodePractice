package practice.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

public class No1235 {

    class Job {
        public int startTime;
        public int endTime;
        public int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            final int n = startTime.length;
            // dp[i] := the maximum profit to schedule jobs[i..n)
            int[] dp = new int[n + 1];
            Job[] jobs = new Job[n];

            for (int i = 0; i < n; ++i) {
                jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            }

            Arrays.sort(jobs, Comparator.comparingInt(a -> a.startTime));

            for (int i = 0; i < n; ++i) {
                startTime[i] = jobs[i].startTime;
            }

            for (int i = n - 1; i >= 0; --i) {
                int j = firstGreaterEqual(startTime, i + 1, jobs[i].endTime);
                int pick = jobs[i].profit + dp[j];
                int skip = dp[i + 1];
                dp[i] = Math.max(pick, skip);
            }

            return dp[0];
        }

        private int firstGreaterEqual(int[] arr, int startFrom, int target) {
            int l = startFrom;
            int r = arr.length;
            while (l < r) {
                final int m = (l + r) / 2;
                if (arr[m] >= target)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }
}
