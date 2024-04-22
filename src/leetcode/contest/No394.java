package leetcode.contest;

import org.junit.jupiter.api.Test;

public class No394 {

    @Test
    public void test() {
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        new Solution100294().numberOfSpecialChars("aaAbcBC");
    }

    class Solution100294 {
        public int numberOfSpecialChars(String word) {
            int[] counter = new int[128];
            for (char c : word.toCharArray()) {
                counter[c]++;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (counter[i + 65] != 0 && counter[i + 97] != 0) {
                    ans++;
                }
            }
            return ans;
        }
    }

    @Test
    public void test100291() {
        System.out.println(new Solution100291().numberOfSpecialChars("AbcbDBdD"));
    }

    class Solution100291 {
        public int numberOfSpecialChars(String word) {
            int[] cache = new int[26];
            int ans = 0;
            for (char c : word.toCharArray()) {
                // a 97 A 65
                // it is upper case
                if (c - 'a' < 0) {
                    if (cache[c - 'A'] > 0) {
                        cache[c - 'A'] = 10001;
                    } else {
                        cache[c - 'A'] = -10001;
                    }
                } else {
                    if (cache[c - 'a'] < 10001) {
                        cache[c - 'a']++;
                    } else {
                        cache[c - 'a'] = -10001;
                    }
                }
            }
            for (int i : cache) {
                if (i >= 10001) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
