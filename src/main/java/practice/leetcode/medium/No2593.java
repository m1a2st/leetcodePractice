package practice.leetcode.medium;

import java.util.TreeSet;

public class No2593 {

    class Solution {
        public long findScore(int[] nums) {
            long ans = 0;
            TreeSet<Pair> numAndIndices =
                    new TreeSet<>((a, b)
                            -> a.key().equals(b.key()) ? a.value().compareTo(b.value())
                            : a.key().compareTo(b.key()));
            boolean[] seen = new boolean[nums.length];

            for (int i = 0; i < nums.length; ++i)
                numAndIndices.add(new Pair(nums[i], i));

            for (Pair pair : numAndIndices) {
                final int num = pair.key();
                final int i = pair.value();
                if (seen[i])
                    continue;
                if (i > 0)
                    seen[i - 1] = true;
                if (i + 1 < nums.length)
                    seen[i + 1] = true;
                seen[i] = true;
                ans += num;
            }

            return ans;
        }
    }

    record Pair(
            Integer key,
            Integer value
    ) {
    }
}
