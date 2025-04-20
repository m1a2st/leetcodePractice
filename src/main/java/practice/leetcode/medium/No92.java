package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No92 {

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode result = solution.reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;

            for (int i = 0; i < left - 1; ++i) {
                prev = prev.next; // Point to the node before the sublist [left, right].
            }

            ListNode tail = prev.next; // Be the tail of the sublist [left, right].

            // Reverse the sublist [left, right] one by one.
            for (int i = 0; i < right - left; ++i) {
                ListNode cache = tail.next;
                tail.next = cache.next;
                cache.next = prev.next;
                prev.next = cache;
            }
            return dummy.next;
        }
    }

    class SolutionNew {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 1. find the left - 1 node
            ListNode dummy = new ListNode(-1, head);
            ListNode pointer = dummy;
            for (int i = 0; i < left - 1; i++) {
                pointer = pointer.next;
            }
            ListNode preLeft = pointer;
            ListNode reverseLeft = pointer.next;
            // 2. find the right + 1 node
            pointer = dummy;
            for (int i = 0; i < right; i++) {
                pointer = pointer.next;
            }
            ListNode reverseRight = pointer;
            ListNode nextRight = pointer.next;
            reverseRight.next = null;
            // reverse the linkedList
            ListNode reverse = reverse(reverseLeft);
            // concat
            preLeft.next = reverse;
            while (reverse.next != null) {
                reverse = reverse.next;
            }
            reverse.next = nextRight;
            return dummy.next;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }

    }
}
