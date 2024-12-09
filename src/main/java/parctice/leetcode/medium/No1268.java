package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1268 {

    @Test
    public void test() {
        List<List<String>> lists =
                new Solution().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        System.out.println(lists);
    }

    class Solution {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            int wLen = searchWord.length();
            List<List<String>> result = new ArrayList<>(wLen);
            Arrays.sort(products);

            int l = 0;
            int r = products.length - 1;

            for (int i = 1; i <= wLen; i++) {
                String substr = searchWord.substring(0, i);
                while (l <= r && equals(substr, i, products[l])) {
                    l++;
                }
                while (r >= l && equals(substr, i, products[r])) {
                    r--;
                }

                List<String> strs = new ArrayList<>(3);

                int added = 0;
                while (added < 3 && l + added <= r) {
                    strs.add(products[l + added++]);
                }
                result.add(strs);
            }
            return result;
        }

        private boolean equals(String substr, int i, String products) {
            return !substr.equals(products.substring(0, Math.min(i, products.length())));
        }
    }
}
