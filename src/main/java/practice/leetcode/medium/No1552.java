package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No1552 {
    
    @Test
    void test() {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(new Solution().maxDistance(position, m));
    }

    class Solution {
        public int maxDistance(int[] position, int m) {
            Arrays.sort(position);

            int left = 1;
            int right = position[position.length - 1] - position[0];

            while (left < right) {
                int mid = right - (right - left) / 2;
                if (numBalls(position, mid) >= m)
                    left = mid;
                else
                    right = mid - 1;
            }

            return left;
        }

        private int numBalls(int[] position, int force) {
            int balls = 0;
            int prevPosition = -force;
            for (int pos : position)
                if (pos - prevPosition >= force) {
                    balls++;
                    prevPosition = pos;
                }
            return balls;
        }
    }
}
