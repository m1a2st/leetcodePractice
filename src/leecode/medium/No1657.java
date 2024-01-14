package leecode.medium;

import java.lang.reflect.Array;
import java.util.*;

public class No1657 {

    class Solution {

        int[] ch1 = new int[26], ch2 = new int[26];

        public boolean closeStrings(String word1, String word2) {

            int len1 = word1.length();
            int len2 = word2.length();
            if (len1 != len2) {
                return false;
            }

            shams(word1, word2);

            for (int i = 0; i < 26; i++) {
                if (ch1[i] > 0 ^ ch2[i] > 0) {
                    return false;
                }
            }
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            return Arrays.equals(ch1, ch2);
        }

        void shams(String word1, String word2) {
            for (int i = 0; i < word1.length(); i++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(i);
                ch1[c1 - 'a']++;
                ch2[c2 - 'a']++;
            }
        }
    }
}
