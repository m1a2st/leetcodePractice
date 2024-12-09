package parctice.leetcode.medium;

import java.util.LinkedList;

/**
 * @Author m1a2st
 * @Date 2023/6/29
 * @Version v1.0
 */
public class No143 {

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode dummy = head.next;
            LinkedList<ListNode> cache = new LinkedList<>();
            while (dummy != null) {
                cache.add(dummy);
                dummy = dummy.next;
            }
            dummy = head;
            while (!cache.isEmpty()) {
                dummy.next = cache.pollLast();
                dummy = dummy.next;
                dummy.next = cache.pollFirst();
                dummy = dummy.next;
            }
            if (dummy != null) {
                dummy.next = null;
            }
        }
    }

    class SolutionReverse {
        public void reorderList(ListNode head) {
            if (head.next != null) {
                ListNode middle = findMiddleNode(head);
                ListNode newHead = middle.next;
                middle.next = null;
                newHead = reverse(newHead, null);
                ListNode curr = head;
                while (newHead != null) {
                    ListNode node = curr.next;
                    curr.next = newHead;
                    newHead = node;
                    curr = curr.next;
                }
            }
        }

        private ListNode findMiddleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow.next;
        }

        public ListNode reverse(ListNode head, ListNode prev) {
            if (head == null) return prev;
            ListNode newHead = head.next;
            head.next = prev;
            return reverse(newHead, head);
        }
    }
}
