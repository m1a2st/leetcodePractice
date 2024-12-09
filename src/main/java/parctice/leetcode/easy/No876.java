package main.java.parctice.leetcode.easy;

import main.java.parctice.leetcode.medium.ListNode;

public class No876 {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head, temp2 = head;
        while (temp2 != null && temp2.next != null) {
            temp = temp.next;
            temp2 = temp2.next.next;
        }
        return temp;
    }

    public ListNode middleNodeNew(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
