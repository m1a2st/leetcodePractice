package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No260 {

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(nums)));
    }

    class Solution {
        public int[] singleNumber(int[] nums) {
            // 使用 a ^ a = 0 這個特性，找到兩個不同數字的 XOR
            int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
            // 找到 XOR 結果中最低位的 1，用意是將兩個不同數字分開
            int lowbit = xors & -xors;
            int[] ans = new int[2];

            for (final int num : nums) {
                // 依照最低位的 1 分成兩組
                //
                if ((num & lowbit) > 0) {
                    ans[0] ^= num;
                }
                else {
                    ans[1] ^= num;
                }
            }

            return ans;
        }
    }

    class SolutionMap {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int[] ans = new int[2];
            int index = 0;
            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    ans[index++] = num;
                }
            }
            return ans;
        }
    }
}
