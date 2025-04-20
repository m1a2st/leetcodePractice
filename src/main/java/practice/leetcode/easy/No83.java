package practice.leetcode.easy;

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
            if (head == null) {
                return null;
            }
            ListNode temp = head;
            while (temp.next != null) {
                if (temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            return head;
        }
    }
}
