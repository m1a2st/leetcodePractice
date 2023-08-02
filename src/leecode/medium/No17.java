package leecode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/1
 * @Version v1.0
 */
public class No17 {

    class Solution {

        List<String> result = new ArrayList<>();
        private static final String[] digitToLetters =
                {"", "", "abc", "def", "ghi",
                        "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) return new ArrayList<>();
            recursive(digits, new StringBuilder(), 0);
            return result;
        }

        private void recursive(String digits, StringBuilder sb, int start) {
            if (digits.length() == start) {
                result.add(sb.toString());
                return;
            }
            for (char c : digitToLetters[digits.charAt(start) - '0'].toCharArray()) {
                sb.append(c);
                recursive(digits, sb, start + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
