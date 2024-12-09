package parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No884 {

    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> cache = new HashMap<>();
            for (String s : s1.split(" ")) {
                cache.merge(s, 1, Integer::sum);
            }
            for (String s : s2.split(" ")) {
                cache.merge(s, 1, Integer::sum);
            }
            ArrayList<String> ans = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                if (entry.getValue() == 1) {
                    ans.add(entry.getKey());
                }
            }

            return ans.toArray(new String[0]);
        }
    }
}
