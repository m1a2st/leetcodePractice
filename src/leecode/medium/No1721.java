package leecode.medium;

import org.junit.jupiter.api.Test;

public class No1721 {

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.swapNodes(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


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
        public ListNode swapNodes(ListNode head, int k) {
            ListNode p = null; // Points k-th node from the beginning.
            ListNode q = null; // Points k-th node from the end.

            for (ListNode curr = head; curr != null; curr = curr.next) {
                if (q != null) {
                    q = q.next;
                }
                if (--k == 0) {
                    p = curr;
                    q = head;
                }
            }

            final int temp = p.val;
            p.val = q.val;
            q.val = temp;
            return head;
        }
    }
}
