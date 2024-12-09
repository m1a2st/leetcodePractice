package main.java.parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No514 {

    @Test
    public void test0() {
        String ring = "godding", key = "gd";
        assertEquals(4, new Solution().findRotateSteps(ring, key));
    }

    class Solution {

        Map<String, Integer> cache = new HashMap<>();

        public int findRotateSteps(String ring, String key) {
            return dfs(ring, key, 0) + key.length();
        }

        // Returns the number of rotates of ring to match key[index..n).
        private int dfs(final String ring, final String key, int index) {
            if (index == key.length()) {
                return 0;
            }
            String hashKey = ring + index;
            if (cache.containsKey(hashKey)) {
                return cache.get(hashKey);
            }

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < ring.length(); i++) {
                if (ring.charAt(i) == key.charAt(index)) {
                    int minRotate = Math.min(i, ring.length() - i);
                    String newRing = ring.substring(i) + ring.substring(0, i);
                    int remainingRotates = dfs(newRing, key, index + 1);
                    ans = Math.min(ans, minRotate + remainingRotates);
                }
            }
            cache.put(hashKey, ans);
            return ans;
        }
    }
}
