package parctice.leetcode.hard;

public class No458 {

    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            int times = minutesToTest / minutesToDie;
            int min = 0, max = buckets;
            while (min < max) {
                int mid = (min + max) / 2;
                if (Math.pow(times + 1, mid) >= buckets) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }
}
