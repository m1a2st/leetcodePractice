package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No92 {

    @Test
    public void test() {
        Solution solution = new Solution();
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
}
