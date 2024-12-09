package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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
            LinkedList<ListNode> stack = new LinkedList<>();
            ListNode cur = head;
            while (cur != null) {
                while (!stack.isEmpty() && stack.peekLast().val < cur.val) {
                    stack.pollLast();
                }
                stack.offer(cur);
                cur = cur.next;
            }
            ListNode ans = new ListNode(-1);
            cur = ans;
            while (!stack.isEmpty()) {
                cur.next = stack.poll();
                cur = cur.next;
            }
            cur.next = null;
            return ans.next;
        }
    }
}
