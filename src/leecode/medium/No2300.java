package leecode.medium;

import java.util.Arrays;

/**
 * @Author m1a2st
 * @Date 2023/4/8
 * @Version v1.0
 */
public class No2300 {
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int[] res = new int[spells.length];
            Arrays.sort(potions);
            for (int i = 0; i < spells.length; i++) {
                res[i] = potions.length - getIndexSuccess(spells[i], potions, success);
            }
            return res;
        }

        private int getIndexSuccess(int spell, int[] potions, long success) {
            int l = 0;
            int r = potions.length;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if((long) potions[mid] * spell >= success){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
