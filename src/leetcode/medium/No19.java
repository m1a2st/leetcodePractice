package leetcode.medium;

public class No19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        Solution.removeNthFromEnd(head, 2);
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 找到要刪除的前一個節點
            ListNode node = findRemoveNode(dummy, n + 1);
            node.next = node.next.next;
            return dummy.next;
        }

        private static ListNode findRemoveNode(ListNode dummy, int i) {
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int j = 0; j < i; j++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    class SolutionNew {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode node = findRemoveNode(dummy, n + 1);
            node.next = node.next.next;
            return dummy.next;
        }

        private ListNode findRemoveNode(ListNode dummy, int n) {
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int i = 0; i < n; i++) {
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
