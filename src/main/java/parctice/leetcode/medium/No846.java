package main.java.parctice.leetcode.medium;

import java.util.TreeMap;

public class No846 {

    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            TreeMap<Integer, Integer> cache = new TreeMap<>();
            for (int card : hand) {
                cache.merge(card, 1, Integer::sum);
            }
            for (int start : cache.keySet()) {
                int value = cache.getOrDefault(start, 0);
                if (value > 0) {
                    for (int i = start; i < start + groupSize; ++i) {
                        if (cache.merge(i, -value, Integer::sum) < 0) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
