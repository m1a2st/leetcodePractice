package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class No234 {

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

    class SolutionFast {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head, prev, temp;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            prev = slow;
            slow = slow.next;
            prev.next = null;
            while (slow != null) {
                temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
            fast = head;
            slow = prev;
            while (slow != null) {
                if (fast.val != slow.val) return false;
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }
    }

    class SolutionSlow {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            List<Integer> ls = new ArrayList<>();
            while (head != null) {
                ls.add(head.val);
                head = head.next;
            }
            int left = 0, right = ls.size() - 1;
            while (left < right) {
                if (!Objects.equals(ls.get(left), ls.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
