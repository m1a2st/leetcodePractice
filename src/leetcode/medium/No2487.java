package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No2487 {


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
        public ListNode removeNodes(ListNode head) {
            if (head == null) {
                return null;
            }
            head.next = removeNodes(head.next);
            return head.next != null && head.val < head.next.val ? head.next : head;
        }
    }

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
        ListNode head = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode result = solution.removeNodes(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    class SolutionNew {
        public ListNode removeNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode prevNode = reverse(head);
            ListNode currentNode = prevNode.next;
            while (currentNode != null) {
                if (currentNode.val < prevNode.val) {
                    currentNode = currentNode.next;
                } else {
                    ListNode nextNode = currentNode.next;
                    currentNode.next = new ListNode(prevNode.val);
                    prevNode = currentNode;
                    currentNode = nextNode;
                }

            }
            head.next = null;
            head = prevNode;
            return head;
        }

        public ListNode reverse(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
