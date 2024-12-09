package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author m1a2st
 * @Date 2023/7/29
 * @Version v1.0
 */
public class No40 {

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        System.out.println(lists);
    }

    class Solution {

        private final Set<List<Integer>> result = new HashSet<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            recursive(candidates, list, target, 0);
            return new ArrayList<>(result);
        }

        public void recursive(int[] candidates, List<Integer> list, int target, int start) {
            if (target < 0) return;
            if (target == 0) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                // 前置作業
                list.add(candidates[i]);
                // 遞迴
                recursive(candidates, list, target - candidates[i], i + 1);
                // 後置作業
                list.remove(list.size() - 1);

            }
        }
    }
}
