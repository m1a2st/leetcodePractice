package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/8/16
 * @Version v1.0
 */
public class No338 {

    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                res[i] = count(i);
            }
            return res;
        }

        private int count(int i) {
            String s = Integer.toString(i, 2);
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    res++;
                }
            }
            return res;
        }
    }
}
