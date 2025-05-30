package practice.leetcode.medium;

import java.util.Arrays;

public class No881 {

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int right = 0, left = people.length - 1;
            int count = 0;
            while (right <= left) {
                if (people[right] + people[left] <= limit) {
                    right++;
                }
                count++;
                left--;
            }
            return count;
        }
    }

    class SolutionBest {
        public int numRescueBoats(int[] people, int limit) {

            int[] buckets = new int[limit + 1];
            for (int weight : people) {
                buckets[weight]++;
            }
            int start = 0;
            int end = buckets.length - 1;
            int boats = 0;
            while (start <= end) {
                while (start <= end && buckets[start] <= 0) start++;
                while (start <= end && buckets[end] <= 0) end--;

                if (buckets[start] <= 0 && buckets[end] <= 0) break;

                boats++;
                if (start + end <= limit) {
                    buckets[start]--;
                }
                buckets[end]--;
            }
            return boats;
        }
    }
}
