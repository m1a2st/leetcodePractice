package practice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No399 {

    class Solution1 {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            int res = 0;
            for (int n1 : nums1) {
                for (int n2 : nums2) {
                    if (check(n1, n2, k)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean check(int n1, int n2, int k) {
            return n1 % (n2 * k) == 0;
        }
    }

    @Test
    public void testCompressedString() {
        Solution2 solution = new Solution2();
        System.out.println(solution.compressedString("aaaaaaaaaaaaaabbbbbcccc"));
    }

    class Solution2 {
        public String compressedString(String word) {
            if (word == null || word.isEmpty()) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    count++;
                    if (count == 10) {
                        sb.append(9);
                        sb.append(word.charAt(i - 1));
                        count = 1;
                    }
                } else {
                    sb.append(count);
                    sb.append(word.charAt(i - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(word.charAt(word.length() - 1));

            return sb.toString();
        }
    }

    class Solution3 {
        public long numberOfPairs(int[] nums1, int[] nums2, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums2) {
                map.put(n * k, map.getOrDefault(n * k, 0) + 1);
            }

            long count = 0;
            for (int n1 : nums1) {
                for (int i = 1; i <= Math.sqrt(n1); i++) {
                    if (n1 % i == 0) {
                        int complement = n1 / i;
                        if (map.containsKey(i)) {
                            count += map.get(i);
                        }
                        if (complement != i && map.containsKey(complement)) {
                            count += map.get(complement);
                        }
                    }
                }
            }
            return count;
        }
    }

}
