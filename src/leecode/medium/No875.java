package leecode.medium;

import java.util.Arrays;

public class No875 {

    public class Solution {
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

        private boolean canEatAll(int[] piles, int h, int mid) {
            int count = 0;
            for (int pile : piles) {
                count += Math.ceil(pile * 1.0 / mid);
            }
            return count <= h;
        }
    }
}

