package parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No228 {

    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            int prev = Integer.MAX_VALUE;
            boolean single = true;
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                if (prev == Integer.MAX_VALUE) {
                    prev = num;
                    sb.append(prev);
                } else {
                    if (prev + 1 == num) {
                        prev = num;
                        single = false;
                    } else {
                        if (!single) {
                            sb.append("->").append(prev);
                        }
                        ans.add(sb.toString());
                        sb.delete(0, sb.length());
                        prev = num;
                        sb.append(prev);
                        single = true;
                    }
                }
            }
            if (!single) {
                sb.append("->").append(prev);
            }
            ans.add(sb.toString());
            return ans;
        }
    }
}
