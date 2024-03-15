package leetcode.easy;

import org.junit.jupiter.api.Test;

public class No203 {

    @Test
    public void test() {Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode result = solution.removeElements(head, 1);
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
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            ListNode dummy = pre.next;
            while (dummy != null) {
                if (dummy.val == val) {
                    pre.next = dummy.next;
                } else {
                    pre = pre.next;
                }
                dummy = dummy.next;
            }
            return head;
        }
    }
}
