package parctice.leetcode.easy;

public class No374 {

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (guess(mid) <= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    class GuessGame {

        public int guess(int n) {
            return n;
        }
    }
}
