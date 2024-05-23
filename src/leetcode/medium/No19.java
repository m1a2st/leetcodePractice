package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No19 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        new Solution().removeNthFromEnd(head, 2);
    }

    /**
     * 1. 找到要刪除的前一個節點
     * 2. 使用快慢指針的方式找到要刪除的前一個節點
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head);
            ListNode preNode = findRemovePreNode(dummy, n + 1);
            preNode.next = preNode.next.next;
            return dummy.next;
        }

        private ListNode findRemovePreNode(ListNode head, int n) {
            ListNode slow = head, fast = head;
            for (int i = 0; i < n; ++i) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
