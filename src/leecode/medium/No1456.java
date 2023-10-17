package leecode.medium;

public class No1456 {

    class Solution {
        public int maxVowels(String s, int k) {
            int ans = 0;
            int counter = 0;
            for (int right = 0, left = 0; right < s.length(); right++) {
                if (isVowel(s.charAt(right))) {
                    counter++;
                }
                if (right - left + 1 == k) {
                    ans = Math.max(ans, counter);
                    if (isVowel(s.charAt(left))) {
                        counter--;
                    }
                    left++;
                }
            }
            return ans;
        }

        public boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
