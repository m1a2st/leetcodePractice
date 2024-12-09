package parctice.leetcode.medium;

import java.util.Arrays;

public class No2326 {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -1;
                }
            }
            if (head == null) return arr;
            int top = 0, left = 0;
            int right = n - 1, button = m - 1;

            while (head != null && top <= button && left <= right) {
                for (int i = left; i <= right; i++) {
                    arr[top][i] = head.val;
                    head = head.next;
                    if (head == null) return arr;
                }
                top++;
                for (int i = top; i <= button; i++) {
                    arr[i][right] = head.val;
                    head = head.next;
                    if (head == null) return arr;
                }
                right--;
                for (int i = right; i >= left; i--) {
                    arr[button][i] = head.val;
                    head = head.next;
                    if (head == null) return arr;
                }
                button--;
                for (int i = button; i >= top; i--) {
                    arr[i][left] = head.val;
                    head = head.next;
                    if (head == null) return arr;
                }
                left++;
            }
            return arr;
        }
    }
}
