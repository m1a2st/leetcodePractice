package parctice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No1461 {

    class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> res = new HashSet<>();
            double ansCount = 1 << k;
            for (int i = 0; i <= s.length() - k; i++) {
                String sub = s.substring(i, i + k);
                if (res.add(sub)) {
                    ansCount--;
                }
            }
            return ansCount == 0;
        }
    }
}
