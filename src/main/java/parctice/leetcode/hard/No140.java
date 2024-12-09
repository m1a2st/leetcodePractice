package main.java.parctice.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class No140 {

    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            dfs(s, wordDict, new ArrayList<>());
            return ans;
        }

        private void dfs(String s, List<String> wordDict, List<String> sub) {
            if (s.isEmpty()) {
                ans.add(String.join(" ", sub));
                return;
            }
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    sub.add(word);
                    dfs(s.substring(word.length()), wordDict, sub);
                    sub.remove(sub.size() - 1);
                }
            }
        }
    }
}
