package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No1291 {

    @Test
    // give me a test
    public void test() {
        SolutionNew solution = new SolutionNew();
        List<Integer> integers = solution.sequentialDigits(100, 300);
        System.out.println(integers);
    }


    class SolutionNew {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < 9; i++) {
                int current = i;
                int nextDigit = i;
                while (current <= high && nextDigit < 10) {
                    if (current >= low) {
                        ans.add(current);
                    }
                    current = current * 10 + ++nextDigit;
                }
            }
            Collections.sort(ans);
            return ans;
        }
    }

    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
            for (int i = low; i < high; i++) {
                if (checkSequentialDigits(i)) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private boolean checkSequentialDigits(int i) {
            String s = String.valueOf(i);
            for (int j = 1; j < s.toCharArray().length; j++) {
                char c = s.charAt(j);
                char c1 = s.charAt(j - 1);
                if (c - c1 != 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
