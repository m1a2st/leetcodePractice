package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1593 {
    
    @Test
    public void test_maxUniqueSplit() {
        Solution s = new Solution();
        assertEquals(5, s.maxUniqueSplit("ababccc"));
        System.out.println(s.maxUniqueSplit("ababccc")); // 5
        System.out.println(s.maxUniqueSplit("aba")); // 2
        System.out.println(s.maxUniqueSplit("aa")); // 1
    }


    class Solution {
        int ans = 0;
        
        public int maxUniqueSplit(String s) {
            backtracking(s, 0, new HashSet<>());
            return ans;
        }

        private void backtracking(String s, int i, HashSet<String> cache) {
            if (i == s.length()) {
                ans = Math.max(ans, cache.size());
                return;
            }
            for (int j = i + 1; j <= s.length(); ++j) {
                String sub = s.substring(i, j);
                if (cache.contains(sub))
                    continue;
                cache.add(sub);
                backtracking(s, j, cache);
                cache.remove(sub);
            }
        }
    }
}
