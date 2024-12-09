package main.java.parctice.leetcode.easy;

import main.java.parctice.leetcode.medium.ListNode;

public class No142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;

            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
