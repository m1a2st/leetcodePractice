package leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/3/21
 * @Version v1.0
 */
public class No344 {

    @Test
    public void test() {
        new Solution().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left <= right) {
                swap(s, left++, right--);
            }
        }

        private void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}
