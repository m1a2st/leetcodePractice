package main.java.parctice.leetcode.medium;

public class No1669 {

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
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            dummy.next = list1;
            ListNode headPoint = dummy;
            ListNode tailPoint = dummy;
            for (int i = 0; i < a; i++) {
                headPoint = headPoint.next;
            }
            for (int i = 0; i < b + 2; i++) {
                tailPoint = tailPoint.next;
            }
            headPoint.next = list2;
            while (headPoint.next != null) {
                headPoint = headPoint.next;
            }
            headPoint.next = tailPoint;
            return dummy.next;
        }
    }
}
