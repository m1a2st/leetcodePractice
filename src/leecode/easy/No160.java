package leecode.easy;

import leecode.medium.ListNode;
import org.junit.jupiter.api.Test;

public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode next = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, next));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, next)));
        ListNode result = solution.getIntersectionNode(headA, headB);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode d1 = headA, d2 = headB;
            while (d1 != d2) {
                if (d1 == null) {
                    d1 = headB;
                }else{
                    d1 = d1.next;
                }
                if (d2 == null) {
                    d2 = headA;
                }else{
                    d2 = d2.next;
                }
            }
            return d1;
        }
    }
}
