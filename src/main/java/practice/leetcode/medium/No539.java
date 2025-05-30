package practice.leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class No539 {

    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int l = timePoints.size();
            int[] minutes = new int[l];
            for (int i = 0; i < l; i++) {
                minutes[i] = convertToMinutes(timePoints.get(i));
            }
            Arrays.sort(minutes);
            int smallestTime = Integer.MAX_VALUE;
            for (int i = 1; i < minutes.length; i++) {
                int diff = minutes[i] - minutes[i - 1];
                smallestTime = Math.min(smallestTime, diff);
            }
            // because time is actually circular so we need to check first ans last time also :
            int circularDiff = (1440 - minutes[l - 1] + minutes[0]);
            smallestTime = Math.min(smallestTime, circularDiff);

            return smallestTime;
        }

        public int convertToMinutes(String time) {
            int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minutes = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            return hours * 60 + minutes;
        }
    }
}
