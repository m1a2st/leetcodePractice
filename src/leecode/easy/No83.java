package leecode.easy;

import org.junit.jupiter.api.Test;

public class No83 {

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(0, new ListNode(0, new ListNode(0)));
        ListNode result = solution.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    //      Definition for singly-linked list.
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-101, head);
            ListNode current = dummy.next;
            ListNode pre = dummy;
            while (current != null) {
                if (pre.val == current.val) {
                    pre.next = current.next;
                } else {
                    pre = pre.next;
                }
                current = current.next;
            }
            return dummy.next;
        }
    }
}
