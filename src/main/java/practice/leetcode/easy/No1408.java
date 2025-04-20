package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No1408 {


    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> ans = new ArrayList<>();
            for (final String a : words)
                for (final String b : words)
                    if (a.length() < b.length() && b.contains(a)) {
                        ans.add(a);
                        break;
                    }
            return ans;
        }
    }
}
