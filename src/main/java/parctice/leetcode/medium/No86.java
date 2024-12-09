package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No86 {

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        Solution solution = new Solution();
        ListNode listNode = solution.partition(a, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
            ListNode p1 = dummy1, p2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = new ListNode(head.val);
                    p2 = p2.next;
                }
                head = head.next;
            }
            p1.next = dummy2.next;
            return dummy1.next;
        }
    }
}
