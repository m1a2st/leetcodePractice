package leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class No2053 {

    class Solution {
        public String kthDistinct(String[] arr, int k) {
            Map<String, Integer> cache = new LinkedHashMap<>();
            for (String s : arr) {
                cache.put(s, cache.getOrDefault(s, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                if (entry.getValue() == 1) {
                    k--;
                }
                if (k == 0) {
                    return entry.getKey();
                }
            }
            return "";
        }
    }
}
