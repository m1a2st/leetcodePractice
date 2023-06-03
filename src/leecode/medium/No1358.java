package leecode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/3/30
 * @Version v1.0
 */
public class No1358 {

    public static void main(String[] args) {
        Solution.numberOfSubstrings("aaacb");
    }

    static class Solution {
        public static int numberOfSubstrings(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int length = s.length();
            int left = 0, right = 0;
            int res = 0;
            while (right < length) {
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                while (!window.containsValue(0) && window.size() == 3) {
                    res += length - right + 1;
                    char d = s.charAt(left);
                    window.put(d, window.get(d) - 1);
                    left++;
                }
            }
            return res;
        }
    }
}
