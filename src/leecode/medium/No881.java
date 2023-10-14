package leecode.medium;

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
}
