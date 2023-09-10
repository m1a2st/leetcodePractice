package leecode.easy;

import org.junit.jupiter.api.Test;

public class No605 {

    @Test
    public void test() {
        new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
    }

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (n == 0) return true;

            for (int i = 0; i < flowerbed.length; ++i)
                if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                        (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    if (--n == 0) return true;
                }
            return false;
        }
    }
}
