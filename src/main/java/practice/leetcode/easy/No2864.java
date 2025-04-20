package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class No2864 {

    @Test
    public void test() {
        System.out.println(new Solution().maximumOddBinaryNumber("010"));
    }

    class Solution {
        public String maximumOddBinaryNumber(String s) {
            int counter = -1;
            for (char c : s.toCharArray()) {
                if (c == '1') ++counter;
            }
            return "1".repeat(Math.max(0, counter)) + "0".repeat(s.length() - counter - 1) + "1";
        }

        public String maximumOddBinaryNumberStream(String s) {
            return IntStream.range(0, 1)
                    .mapToObj(n -> "1".repeat(s.chars()
                            .mapToObj(c -> (char) c)
                            .filter(c -> c == '1')
                            .toList()
                            .size() - 1) + "0".repeat(s.length() - s.chars()
                            .mapToObj(c -> (char) c)
                            .filter(c -> c == '1')
                            .toList()
                            .size()) + "1")
                    .collect(Collectors.joining());

        }
    }
}
