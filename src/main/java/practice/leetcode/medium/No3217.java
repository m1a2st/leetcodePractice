package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No3217 {

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
        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                if (set.contains(curr.val)) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            
            return dummy.next;  
        }
    }
}
