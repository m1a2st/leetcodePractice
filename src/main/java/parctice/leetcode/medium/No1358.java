package parctice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/3/30
 * @Version v1.0
 */
public class No1358 {

    class Solution {
        // Similar to 3. Longest SubString Without Repeating Characters
        public int numberOfSubstrings(String s) {
            int ans = 0;
            int[] count = new int[3];

            int l = 0;
            for (final char c : s.toCharArray()) {
                ++count[c - 'a'];
                while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                    --count[s.charAt(l++) - 'a'];
                // s[0..r], s[1..r], ..., s[l - 1..r] are satified strings.
                ans += l;
            }

            return ans;
        }
    }
}
