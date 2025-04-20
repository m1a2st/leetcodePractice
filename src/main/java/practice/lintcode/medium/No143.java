package practice.lintcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No143 {

    @Test
    public void test() {
        new Solution().sortColors2(new int[]{3, 2, 2, 1, 4}, 4);
    }

    public class Solution {
        /**
         * @param colors: A list of integer
         * @param k:      An integer
         * @return: nothing
         */
        public void sortColors2(int[] colors, int k) {
            int[] pointer = new int[k + 1];
            Arrays.fill(pointer, -1);
            for (int color : colors) {
                for (int i = k; i >= color; i--) {
                    colors[++pointer[i]] = i;
                }
            }
        }

        public void swap(int[] colors, int left, int right) {
            int temp = colors[left];
            colors[left] = colors[right];
            colors[right] = temp;
        }
    }
}
