package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class No1079 {

    @Test
    public void test() {
        System.out.println(new Solution().numTilePossibilities("AAB"));
    }

    class Solution{
        public int numTilePossibilities(String tiles) {
            int[] count = new int[26];
            for (char t : tiles.toCharArray())
                ++count[t - 'A'];
            return dfs(count);
        }

        private int dfs(int[] count) {
            int possibleSequences = 0;
            for (int i = 0; i < 26; ++i) {
                if (count[i] == 0)
                    continue;
                --count[i];
                possibleSequences += 1 + dfs(count);
                ++count[i];
            }
            return possibleSequences;
        }
    }
}
