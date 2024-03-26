package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No274 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int ans = solution.hIndex(new int[]{1, 3, 1});
        System.out.println(ans);
    }

    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            Arrays.sort(citations);

            for (int i = 0; i < len; ++i)
                if (citations[i] >= len - i){
                    return len - i;
                }

            return 0;
        }
    }
}
