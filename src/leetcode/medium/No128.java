package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author m1a2st
 * @Date 2023/6/5
 * @Version v1.0
 */
public class No128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int ans = 0;
            for (Integer i : seen) {
                if(seen.contains(i - 1)){
                    continue;
                }
                int length = 1;
                while (seen.contains(i + 1)) {
                    length++;
                    i++;
                }
                ans = Math.max(ans, length);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        assert solution.longestConsecutive(nums) == 4;
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assert solution.longestConsecutive(nums) == 9;
    }
}
