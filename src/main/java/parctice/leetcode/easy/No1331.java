package parctice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1331 {

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            int rank = 1;
            for (int i = 0; i < sorted.length; i++) {
                if (i == 0 || sorted[i] != sorted[i - 1]) {
                    map.put(sorted[i], rank++);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = map.get(arr[i]);
            }
            return arr;
        }
    }
}
