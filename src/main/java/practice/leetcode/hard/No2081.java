package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2081 {

    class Solution {
        public long kMirror(int k, int n) {
            long ans = 0;
            List<String> A = new ArrayList<>(List.of("0"));

            for (int i = 0; i < n; i++) {
                while (true) {
                    A = nextKMirror(A, k);
                    long num = Long.parseLong(String.join("", A), k);
                    if (isPalindrome(String.valueOf(num))) {
                        break;
                    }
                }
                ans += Long.parseLong(String.join("", A), k);
            }
            return ans;
        }

        private List<String> nextKMirror(List<String> A, int k) {
            List<String> result = new ArrayList<>(A);

            for (int i = result.size() / 2; i < result.size(); i++) {
                int nextNum = Integer.parseInt(result.get(i)) + 1;
                if (nextNum < k) {
                    result.set(i, String.valueOf(nextNum));
                    result.set(result.size() - 1 - i, String.valueOf(nextNum));

                    // 將前面的位數重置為 0
                    for (int j = result.size() / 2; j < i; j++) {
                        result.set(j, "0");
                        result.set(result.size() - 1 - j, "0");
                    }
                    return result;
                }
            }

            // 如果無法增加，需要增加位數
            List<String> newResult = new ArrayList<>();
            newResult.add("1");
            for (int i = 0; i < result.size() - 1; i++) {
                newResult.add("0");
            }
            newResult.add("1");
            return newResult;
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
