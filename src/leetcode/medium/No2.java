package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;
        int sum;
        int h = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + h;
            } else if (l1 == null) {
                sum = l2.val + h;
            } else {
                sum = l1.val + h;
            }
            if (sum > 9) {
                node.val = sum % 10;
                h = 1;
            } else {
                node.val = sum;
                h = 0;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            if (l1 != null || l2 != null) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        if (h == 1) {
            node.next = new ListNode();
            node.next.val = 1;
        }
        return head;
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);
            ListNode head = result;
            int sum;
            int h = 0;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    sum = l1.val + l2.val + h;
                } else if (l1 == null) {
                    sum = l2.val + h;
                } else {
                    sum = l1.val + h;
                }
                if (sum < 9) {
                    result.next = new ListNode(sum);
                    h = 0;
                } else {
                    result.next = new ListNode(sum % 10);
                    h = 1;
                }
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                result = result.next;
            }
            if (h == 1) {
                result.next = new ListNode(1);
            }
            return head.next;
        }
    }

    @Test
    public void test() {
        new SolutionNew().addTwoNumbers(new ListNode(4), new ListNode(5));
    }

    class SolutionNew {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode res = dummy;
            int level = 0;
            while (l1 != null || l2 != null) {
                int sum;
                if (l1 != null && l2 != null) {
                    sum = l1.val + l2.val + level;
                } else if (l1 == null) {
                    sum = l2.val + level;
                } else {
                    sum = l1.val + level;
                }
                if (sum <= 9) {
                    dummy.next = new ListNode(sum);
                    level = 0;
                } else {
                    dummy.next = new ListNode(sum % 10);
                    level = 1;
                }
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                dummy = dummy.next;
            }
            if (level == 1) {
                dummy.next = new ListNode(1);
            }
            return res.next;
        }
    }
}

