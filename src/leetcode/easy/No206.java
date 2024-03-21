package leetcode.easy;

import leetcode.medium.ListNode;

import java.util.Stack;

public class No206 {

    static class SolutionOld {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }


    class SolutionNoRecursive {
        public ListNode reverseList(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (!stack.isEmpty()) {
                ListNode node = new ListNode(stack.pop());
                cur.next = node;
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    class SolutionRecursive {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
}
