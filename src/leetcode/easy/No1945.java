package leetcode.easy;

public class No1945 {

    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c - 'a' + 1);
            }
            String str = sb.toString();
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }
            for (int i = 1; i < k; i++) {
                sum = transform(sum);
            }
            return sum;
        }

        private int transform(int sum) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            return newSum;
        }
    }
}
