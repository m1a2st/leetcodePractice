package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No2181 {
    
    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode result = solution.mergeNodes(head);
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
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode cur = dummy.next;
            // remove first 0
            head = head.next; 
            int sum = 0;
            while (head != null) {
                if (head.val == 0) {
                    cur.next = new ListNode(sum);
                    cur = cur.next;
                    sum = 0;
                } else {
                    sum += head.val;
                }
                head = head.next;
            }

            return dummy.next;
        }
    }
}
