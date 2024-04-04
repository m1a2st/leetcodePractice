package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No30 {

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            if (s.isEmpty() || words.length == 0) {
                return ans;
            }
            // 總共幾個單字
            int len = words.length;
            // 每個單字的長度
            int sLen = words[0].length();
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.merge(word, 1, Integer::sum);
            }
            for (int i = 0; i <= s.length() - len * sLen; ++i) {
                Map<String, Integer> seen = new HashMap<>();
                // 截斷每個單字的起始 index
                int j = 0;
                for (; j < len; ++j) {
                    String word = s.substring(i + j * sLen, i + j * sLen + sLen);
                    seen.merge(word, 1, Integer::sum);
                    if (seen.get(word) > map.getOrDefault(word, 0)) {
                        break;
                    }
                }
                // 找到所有的單字，就把起始點加入答案
                if (j == len) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
