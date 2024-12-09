package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/3/30
 * @Version v1.0
 */
public class No904 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3});
    }

    class Solution {
        public int totalFruit(int[] fruits) {
            int max = 0;
            int len = fruits.length;
            Map<Integer, Integer> bucket = new HashMap<>();
            for (int right = 0, left = 0; right < len; right++) {
                bucket.put(fruits[right], bucket.getOrDefault(fruits[right], 0));
                while (bucket.size() > 2 && left < right) {
                    int fruit = fruits[left];
                    bucket.put(fruit, bucket.get(fruit) - 1);
                    if (bucket.get(fruit) == 0) {
                        bucket.remove(fruit);
                    }
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
}
