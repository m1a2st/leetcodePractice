package leetcode.easy;

public class No9 {

    public boolean isPalindrome(int x) {
        int temp = 0;
        int y = x;
        while (y > 0) {
            temp = temp * 10 + y % 10;
            y /= 10;
        }
        return temp == x;
    }
}
