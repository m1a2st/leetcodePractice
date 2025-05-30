package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No187 {

    @Test
    public void test() {
        Solution solution = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution.findRepeatedDnaSequences(s));
    }

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> ans = new HashSet<>();
            Set<String> seen = new HashSet<>();

            for (int i = 0; i + 10 <= s.length(); ++i) {
                final String seq = s.substring(i, i + 10);
                if (seen.contains(seq)) {
                    ans.add(seq);
                }
                seen.add(seq);
            }

            return new ArrayList<>(ans);
        }
    }
}
