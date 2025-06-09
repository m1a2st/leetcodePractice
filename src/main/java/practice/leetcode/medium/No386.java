package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No386 {
    
    @Test
    void test() {
        System.out.println(new Solution().lexicalOrder(123));
    }
    
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            int curr = 1;

            while (ans.size() < n) {
                ans.add(curr);
                if (curr * 10 <= n) {
                    curr *= 10;
                } else {
                    while (curr % 10 == 9 || curr == n)
                        curr /= 10;
                    ++curr;
                }
            }

            return ans;
        }
    }
}
