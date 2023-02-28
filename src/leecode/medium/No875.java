package leecode.medium;

import java.util.Arrays;

public class No875 {

    public static void main(String[] args) {

    }

    public static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Arrays.stream(piles).max().getAsInt();
            int ans = max;
            int len = piles.length;
            if (h == len) {
                return max;
            } else {
                int left = 1;
                int right = max;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (canEatAll(piles, h, mid)) {
                        ans = mid;
                        right = mid ;
                    }else{
                        left = mid + 1;
                    }
                }
            }
            return ans;
        }

        private boolean canEatAll(int[] piles, int h, int speed) {
            int total = 0;
            for (int pile : piles) {
                total += (int) Math.ceil(pile * 1.0 / speed);
            }
            return total <= h;
        }
    }
}

