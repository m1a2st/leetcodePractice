package leetcode.contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No396 {

    @Test
    public void test() {
        System.out.println(Integer.valueOf('0')); // 48
        System.out.println(Integer.valueOf('9')); // 57
        System.out.println(Integer.valueOf('A')); // 65
        System.out.println(Integer.valueOf('Z')); // 90
        System.out.println(Integer.valueOf('a')); // 97
        System.out.println(Integer.valueOf('z')); // 122
    }

    class Solution100284 {
        public boolean isValid(String word) {
            boolean isNum = false;
            boolean isVowel = false;
            boolean isConsonant = false;
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');
            int counter = 0;
            for (char c : word.toCharArray()) {
                if (!(c >= 65 && c <= 97) && !(c >= 97 && c <= 122) && !(c >= 48 && c <= 57)) {
                    return false;
                }
                if (c >= 48 && c <= 57) {
                    counter++;
                }
                if ((c >= 65 && c <= 97) || (c >= 97 && c <= 122)) {
                    counter++;
                    if (vowels.contains(c)) {
                        isVowel = true;
                    } else {
                        isConsonant = true;
                    }
                }
                if (counter == 3) {
                    isNum = true;
                }
            }
            return isVowel && isConsonant && isNum;
        }
    }

    @Test
    public void test100275() {
        Solution100275 solution100275 = new Solution100275();
        solution100275.minimumOperationsToMakeKPeriodic("leetcodeleet", 4);
    }

    class Solution100275 {
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            HashMap<String, Integer> cache = new HashMap<>();
            int total = 0;
            for (int i = 0; i < word.length(); ) {
                int end = i + k;
                String sub = word.substring(i, end);
                cache.merge(sub, 1, Integer::sum);
                total++;
                i = end;
            }
            int ans = Integer.MAX_VALUE;
            for (Integer value : cache.values()) {
                ans = Math.min(ans, total - value);
            }
            return ans;
        }
    }

    @Test
    public void test100283() {
        Solution100283 solution100283 = new Solution100283();
        Assertions.assertEquals(2, solution100283.minAnagramLength("enenen"));
        Assertions.assertEquals(2, solution100283.minAnagramLength("abba"));
    }

    public class Solution100283 {

        public int minAnagramLength(String s) {
            int len = s.length();
            Map<Character, Integer> frequency = new HashMap<>();
            for (char c : s.toCharArray()) {
                frequency.merge(c, 1, Integer::sum);
            }

            for (int i = 1; i <= len; i++) {
                int temp = i;
                if (len % i == 0) {
                    if (frequency.values()
                            .stream()
                            .allMatch(freq -> freq % (len / temp) == 0)) {
                        return i;
                    }
                }
            }
            return len;
        }
    }
}


