package leetcode.medium;

public class No7 {

    class Solution {
        public int reverse(int x) {
            long result = 0;
            while (x != 0){
                result = x % 10 + result * 10 ;
                 x = x / 10;
            }
            return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int)result;
        }
    }
}
