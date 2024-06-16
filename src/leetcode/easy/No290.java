package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No290 {

    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }

    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;

            Map<Character, Integer> charToIndex = new HashMap<>();
            Map<String, Integer> stringToIndex = new HashMap<>();

            for (int i = 0; i < pattern.length(); ++i)
                if (!Objects.equals(charToIndex.put(pattern.charAt(i), i), stringToIndex.put(words[i], i)))
                    return false;

            return true;
        }
    }
}
