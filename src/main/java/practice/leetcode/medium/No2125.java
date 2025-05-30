package practice.leetcode.medium;

public class No2125 {


    class Solution {
        public int numberOfBeams(String[] bank) {
            int prevRowCount = 0;
            int total = 0;

            for (String row : bank) {
                int curRowCount = calc(row);
                if (curRowCount > 0) {
                    total += curRowCount * prevRowCount;
                    prevRowCount = curRowCount;
                }
            }
            return total;
        }

        private int calc(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                count += c - '0';
            }
            return count;
        }
    }
}
