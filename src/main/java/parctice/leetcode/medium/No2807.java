package parctice.leetcode.medium;

public class No2807 {

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
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (head != null) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
                head = head.next;
                if (head != null) {
                    int gcd = gcd(cur.val, head.val);
                    cur.next = new ListNode(gcd);
                    cur = cur.next;
                }
            }
            return dummy.next;
        }

        public static int gcd(int a, int b) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            int r = max % min;
            if (r == 0) {
                return min;
            }
            return gcd(min, r);
        }
    }
}
