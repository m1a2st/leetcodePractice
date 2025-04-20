package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class No967 {

    @Test
    public void test() {
        Solution solution = new Solution();
        for (int i : solution.numsSameConsecDiff(3, 7)) {
            System.out.println(i);
        }
    }

    class Solution {
        Set<Integer> ans = new HashSet<>();

        public int[] numsSameConsecDiff(int n, int k) {
            for (int i = 1; i < 10; i++) {
                backtracking(i, n - 1, k);
            }
            int[] res = new int[ans.size()];
            int i = 0;
            for (Integer an : ans) {
                res[i++] = an;
            }
            return res;
        }

        private void backtracking(int num, int n, int k) {
            if (n == 0) {
                ans.add(num);
                return;
            }

            int newNum = num * 10;
            int compareNum = num % 10;
            int addNext = compareNum + k;
            if (addNext <= 9) {
                newNum += addNext;
                backtracking(newNum, n - 1, k);
                newNum -= addNext;
            }

            int subNext = compareNum - k;
            if (subNext >= 0) {
                newNum += subNext;
                backtracking(newNum, n - 1, k);
            }
        }
    }
}
