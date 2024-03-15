package leetcode.medium;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/4/12
 * @Version v1.0
 */
public class No61 {

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
        Solution solution = new Solution();
        solution.rotateRight(head, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //找長度（有想到）
        int len = 1;
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            len++;
        }
        //變成circle list（沒想到）
        tailNode.next = head;
        //要移動多少個位置（有想到）
        int shift = len - k % len;
        for (int i = 0; i < shift; i++) {
            tailNode = tailNode.next;
        }
        ListNode newNode = tailNode.next;
        tailNode.next = null;
        return newNode;
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            int len = 1;
            ListNode measure = head;
            while (measure.next != null) {
                measure = measure.next;
                len++;
            }
            measure.next = head;
            int shift = len - k % len;
            for (int i = 0; i < shift; i++) {
                measure = measure.next;
            }
            ListNode ans = measure.next;
            measure.next = null;
            return ans;
        }
    }
}
