package parctice.leetcode.medium;


public class No1898 {

    class Solution {
        public int maximumRemovals(String s, String p, int[] removable) {
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            int start = 0;
            int end = removable.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                for (int i = start; i <= mid; i++) {
                    sArr[removable[i]] = '*';
                }
                if (isSubSequence(sArr, pArr))
                    start = mid + 1;
                else {
                    for (int i = start; i <= mid; i++) {
                        sArr[removable[i]] = s.charAt(removable[i]);
                    }
                    end = mid - 1;
                }
            }
            return end + 1;

        }

        private boolean isSubSequence(char[] sArr, char[] pArr) {
            int i = 0, j = 0;
            while (i < sArr.length && j < pArr.length) {
                if (sArr[i] == pArr[j]) {
                    j++;
                }
                i++;
            }
            return j == pArr.length;
        }
    }
}
