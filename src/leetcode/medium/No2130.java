package leetcode.medium;

public class No2130 {


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
        public int pairSum(ListNode head) {
            ListNode slow = new ListNode(0, head), fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode halfReverse = reverse(slow.next);
            int ans = 0;
            while (halfReverse != null && head != null) {
                ans = Math.max(halfReverse.val + head.val, ans);
                halfReverse = halfReverse.next;
                head = head.next;
            }
            return ans;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    class SolutionNew {
        public int pairSum(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null, curr = slow;

            while (curr != null) {
                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            int maxTwinSum = 0;
            ListNode head1 = head;
            ListNode head2 = prev;

            while (head1 != null && head2 != null) {
                maxTwinSum = Math.max(maxTwinSum, head1.val + head2.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            return maxTwinSum;
        }
    }
}
