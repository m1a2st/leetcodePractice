package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No2816 {


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

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(8, new ListNode(9)));
        new Solution().doubleIt(head);
    }

    class Solution {
        public ListNode doubleIt(ListNode head) {
            ListNode dummy = head;
            ListNode prev = null, cur = head;
            while (cur != null) {
                int currentVal = cur.val * 2;
                int sec = currentVal / 10;
                int fir = currentVal % 10;
                if (prev == null) {
                    if (sec != 0) {
                        dummy = new ListNode(sec, head);
                    }
                    prev = head;
                } else {
                    prev.val = prev.val + sec;
                    prev = prev.next;
                }
                cur.val = fir;
                cur = cur.next;
            }
            return dummy;
        }
    }
}
