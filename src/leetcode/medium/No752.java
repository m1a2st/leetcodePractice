package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No752 {

    @Test
    public void test() {
        System.out.println(new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deads = new HashSet<>(List.of(deadends));
            if (deads.contains("0000")) {
                return -1;
            }
            if (target.equals("0000")) {
                return 0;
            }
            HashSet<String> visited = new HashSet<>();
            int step = 0;
            visited.add("0000");
            while (!visited.isEmpty()) {
                HashSet<String> temp = new HashSet<>();
                for (String s : visited) {
                    for (int i = 0; i < 4; i++) {
                        String plus = plusOne(s, i);
                        if (plus.equals(target)) {
                            return step + 1;
                        }
                        if (!deads.contains(plus) && !visited.contains(plus)) {
                            deads.add(plus);
                            temp.add(plus);
                        }
                        String minus = minusOne(s, i);
                        if (minus.equals(target)) {
                            return step + 1;
                        }
                        if (!deads.contains(minus) && !visited.contains(minus)) {
                            deads.add(plus);
                            temp.add(minus);
                        }
                    }
                }
                visited = temp;
                step++;
            }
            return -1;
        }

        private String plusOne(String s, int i) {
            char[] chars = s.toCharArray();
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            return new String(chars);
        }

        private String minusOne(String s, int i) {
            char[] chars = s.toCharArray();
            chars[i] = (char) ((chars[i] - '0' - 1 + 10) % 10 + '0');
            return new String(chars);
        }
    }
}
