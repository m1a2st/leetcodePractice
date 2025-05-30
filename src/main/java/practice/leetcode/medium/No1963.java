package practice.leetcode.medium;

public class No1963 {


    class Solution {
        public int minSwaps(String s) {
            // Cancel out all the matched pairs, then we'll be left with "]]]..[[[".
            // The answer is ceil(the number of unmatched pairs / 2).
            int unmatched = 0;

            for (final char c : s.toCharArray())
                if (c == '[')
                    ++unmatched;
                else if (unmatched > 0) // c == ']' and there's a match.
                    --unmatched;

            return (unmatched + 1) / 2;
        }
    }
}
