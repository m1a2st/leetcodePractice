package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class No3136 {

    class Solution {
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
}
