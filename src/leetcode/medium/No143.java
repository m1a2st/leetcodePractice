package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author m1a2st
 * @Date 2023/6/29
 * @Version v1.0
 */
public class No143 {

    class SolutionOld {
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

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode copy = head;
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int left = 1, right = list.size() - 1;
            while (left <= right) {
                ListNode lNode = list.get(left);
                ListNode rNode = list.get(right);
                lNode.next = rNode;
                left++;
                if (left == right) {
                    break;
                }
                rNode.next = lNode;
                right--;
            }
            list.get(left).next = null;
        }
    }
}
