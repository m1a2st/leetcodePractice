package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No148 {


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
        public ListNode sortList(ListNode head) {
            Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l1 -> l1.val));
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
            ListNode ans = new ListNode(0);
            ListNode res = ans;
            while (!queue.isEmpty()) {
                ans.next = queue.poll();
                ans = ans.next;
            }
            ans.next = null;
            return res.next;
        }
    }

    class SolutionMergeSort {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mid = searchMid(head);
            ListNode midNext = mid.next;
            mid.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(midNext);
            return mergeLinkedList(l1, l2);
        }

        private ListNode searchMid(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode mergeLinkedList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode temp = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    dummy.next = l2;
                    l2 = l2.next;
                } else {
                    dummy.next = l1;
                    l1 = l1.next;
                }
                dummy = dummy.next;
            }
            if (l1 != null) {
                dummy.next = l1;
            }
            if (l2 != null) {
                dummy.next = l2;
            }
            return temp;
        }
    }
}
