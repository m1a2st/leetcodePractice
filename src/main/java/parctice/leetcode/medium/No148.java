package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No148 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new SolutionNew().sortList(l1);
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

    class SolutionNew {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mid = findMidNode(head);
            ListNode right = mid.next;
            mid.next = null;
            ListNode sortLeft = sortList(head);
            ListNode sortRight = sortList(right);
            return merge(sortLeft, sortRight);
        }

        private ListNode findMidNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            if (left != null) {
                cur.next = left;
            }
            if (right != null) {
                cur.next = right;
            }
            return dummy.next;
        }
    }
}
