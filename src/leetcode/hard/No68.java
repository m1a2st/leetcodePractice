package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No68 {

    @Test
    public void test123() {
        String s = "enough to explain to";
        System.out.println(s.length());
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough",
                "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> res = solution.fullJustify(words, maxWidth);
        for (String s : res) {
            System.out.println(s);
        }
    }

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            List<String> cache = new ArrayList<>();
            int sum = 0;
            for (String word : words) {
                sum += word.length();
                if (sum == maxWidth) {
                    cache.add(word);
                    ans.add(concatString(cache, maxWidth));
                    cache.clear();
                    sum = 0;
                    continue;
                }
                if (sum > maxWidth) {
                    ans.add(concatString(cache, maxWidth));
                    sum = 0;
                    sum += word.length();
                    cache.clear();
                }
                sum += 1;
                cache.add(word);
            }
            if (!cache.isEmpty()) {
                ans.add(concatLastString(cache, maxWidth));
            }
            return ans;
        }

        private String concatLastString(List<String> cache, int maxWidth) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < cache.size(); i++) {
                res.append(cache.get(i));
                if (i < cache.size() - 1) {
                    res.append(" ");
                }
            }
            return res.append(" ".repeat(Math.max(0, maxWidth - res.length()))).toString();
        }

        private String concatString(List<String> cache, int maxWidth) {
            StringBuilder res = new StringBuilder();
            if (cache.size() == 1) {
                String s = cache.get(0);
                return s + " ".repeat(maxWidth - s.length());
            }
            int sum = 0;
            for (String s : cache) {
                sum += s.length();
            }
            int space = maxWidth - sum;
            int n = cache.size() - 1;
            int avg = space / n;
            int mod = space % n;
            for (int i = 0; i < cache.size(); i++) {
                res.append(cache.get(i));
                if (i < n) {
                    res.append(" ".repeat(avg));
                    if (mod > 0) {
                        res.append(" ");
                        mod--;
                    }
                }
            }
            return res.toString();
        }
    }
}
