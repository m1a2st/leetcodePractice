package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No875 {

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Arrays.stream(piles).max().getAsInt();
            if (piles.length == h) {
                return max;
            }
            int left = 1, right = max;
            int ans = max;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (getEatAll(piles, mid, h)) {
                    ans = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

        private boolean getEatAll(int[] piles, int num, int time) {
            int count = 0;
            for (int pile : piles) {
                if (pile % num == 0) {
                    count += pile / num;
                } else {
                    count += pile / num + 1;
                }
            }
            return count <= time;
        }
    }

    @Test
    public void Test() {
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int ans = solution.minEatingSpeed(piles, h);
        assertEquals(4, ans);
    }

    @Test
    public void Test2() {
        Solution solution = new Solution();
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int ans = solution.minEatingSpeed(piles, h);
        assertEquals(30, ans);
    }

    @Test
    public void Test3() {
        Solution solution = new Solution();
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int ans = solution.minEatingSpeed(piles, h);
        assertEquals(23, ans);
    }
}

