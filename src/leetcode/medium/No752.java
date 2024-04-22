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
            Set<String> set = new HashSet<>(List.of(deadends));
            if (set.contains("0000")) {
                return -1;
            }
            if (target.equals("0000")) {
                return 0;
            }
            Set<String> visited = new HashSet<>();
            visited.add("0000");
            int step = 0;
            while (!visited.isEmpty()) {
                Set<String> temp = new HashSet<>();
                for (String s : visited) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = -1; j <= 1; j += 2) {
                            char[] chars = s.toCharArray();
                            chars[i] = (char) ((chars[i] - '0' + j + 10) % 10 + '0');
                            String newStr = new String(chars);
                            if (newStr.equals(target)) {
                                return step + 1;
                            }
                            if (!set.contains(newStr)) {
                                temp.add(newStr);
                                set.add(newStr);
                            }
                        }
                    }
                }
                visited = temp;
                step++;
            }
            return -1;
        }
    }
}
