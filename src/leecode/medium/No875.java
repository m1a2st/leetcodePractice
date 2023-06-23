package leecode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No875 {

    public class SolutionOld {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Arrays.stream(piles).max().getAsInt();
            int ans = max;
            int len = piles.length;
            if (h == len) {
                return max;
            } else {
                int left = 0, right = len - 1;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (canEatAll(piles, h, mid)) {
                        ans = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return ans;
        }
    }

    public class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Arrays.stream(piles).max().getAsInt();
            int ans = max;
            int len = piles.length;
            if (h == len) {
                return max;
            } else {
                int left = 1, right = max;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (canEatAll(piles, h, mid)) {
                        ans = mid;
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return ans;
        }

        private boolean canEatAll(int[] piles, int h, int mid) {
            int count = 0;
            for (int pile : piles) {
                count += Math.ceil(pile * 1.0 / mid);
            }
            return count < h;
        }
    }

    private boolean canEatAll(int[] piles, int h, int mid) {
        int count = 0;
        for (int pile : piles) {
            count += Math.ceil(pile * 1.0 / mid);
        }
        return count <= h;
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

