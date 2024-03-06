package leecode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No948 {

    @Test
    public void test() {
        new Solution().bagOfTokensScore(new int[]{71, 55, 82}, 54);
    }

    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            Arrays.sort(tokens);
            int left = 0, right = tokens.length;
            int ans = 0;
            while (left < right) {
                if (power >= tokens[left]) {
                    power -= tokens[left];
                    ++ans;
                    ++left;
                } else if (ans > 0) {
                    --right;
                    power += tokens[right];
                    if (left == right || power < tokens[left]) {
                        return ans;
                    }
                    --ans;
                } else {
                    return ans;
                }
            }
            return ans;
        }
    }
}
