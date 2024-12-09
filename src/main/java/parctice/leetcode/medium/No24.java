package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No24 {

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(a);
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode temp = dummy;
            while (temp.next != null && temp.next.next != null) {
                ListNode node1 = temp.next;
                ListNode node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }
            return dummy.next;
        }
    }
}
