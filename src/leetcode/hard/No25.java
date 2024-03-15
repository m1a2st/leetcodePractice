package leetcode.hard;

import leetcode.medium.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No25 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Solution.reverseKGroup(a, 2);
    }

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        Solution.reverse(a, b);
    }

    static class Solution {
        public static ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }
            ListNode newHead = reverse(head, tail);
            head.next = reverseKGroup(tail, k);
            return newHead;
        }

        // Reverses [head, tail)
        public static ListNode reverse(ListNode head, ListNode tail) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != tail) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
