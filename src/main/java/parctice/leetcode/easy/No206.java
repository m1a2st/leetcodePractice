package main.java.parctice.leetcode.easy;

import main.java.parctice.leetcode.medium.ListNode;

public class No206 {

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    class SolutionNew {
        public ListNode reverseList(ListNode head) {
            return reverseList(head, null);
        }

        private ListNode reverseList(ListNode head, ListNode prev) {
            if (head == null) return prev;
            ListNode newNode = head.next;
            head.next = prev;
            return reverseList(newNode, head);
        }
    }

    public ListNode reverseListByLoop(ListNode current) {
        if (current == null) {
            return null;
        }

        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
