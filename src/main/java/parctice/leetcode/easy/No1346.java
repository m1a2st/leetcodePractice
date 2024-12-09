package main.java.parctice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class No1346 {

    class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> cache = new HashSet<>();

            for (int num : arr) {
                if (cache.contains(num * 2) || (num % 2 == 0 && cache.contains(num / 2))) {
                    return true;
                }
                cache.add(num);
            }
            return false;
        }
    }
}
