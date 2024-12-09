package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class No315 {
    @Test
    public void test() {
        int[] nums = {5, 2, 6, 1};
        System.out.println(new Solution().countSmaller(nums));
    }

    class FenwickTree {

        private final int[] sums;

        // 返回 i 的二進制表示中最低位的 1 所代表的數值
        private static int lowbit(int i) {
            return i & -i;
        }

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        public int get(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }

    }

    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> ranks = getRanks(nums);
            FenwickTree tree = new FenwickTree(ranks.size());

            for (int i = nums.length - 1; i >= 0; --i) {
                int num = nums[i];
                ans.add(tree.get(ranks.get(num) - 1));
                tree.update(ranks.get(num), 1);
            }

            Collections.reverse(ans);
            return ans;
        }

        private Map<Integer, Integer> getRanks(int[] nums) {
            Map<Integer, Integer> ranks = new HashMap<>();
            SortedSet<Integer> sorted = new TreeSet<>();
            for (final int num : nums)
                sorted.add(num);
            int rank = 0;
            for (Integer integer : sorted) {
                ranks.put(integer, ++rank);
            }
            return ranks;
        }
    }
}
