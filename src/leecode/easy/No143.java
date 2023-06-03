package leecode.easy;

import leecode.medium.ListNode;

import java.util.Stack;

public class No143 {

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode copy = head;
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }

            while (copy != null) {
                ListNode pop = stack.pop();
                if (pop == copy) {
                    break;
                }
                ListNode tmp = copy.next;
                if (tmp == pop) {
                    break;
                }
                copy.next = pop;
                copy = copy.next;
                copy.next = tmp;
                copy = copy.next;
            }
        }
    }
}
