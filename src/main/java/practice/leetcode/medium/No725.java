package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No725 {

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode[] result = solution.splitListToParts(head, 3);
        for (ListNode listNode : result) {
            while (listNode != null) {
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
            System.out.println("============");
        }
    }


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
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] ans = new ListNode[k];
            int length = getLength(root);
            int subLength = length / k;
            int remainder = length % k;
            ListNode prev = null;
            ListNode dummy = root;
            for (int i = 0; i < k; i++) {
                ans[i] = dummy;
                for (int j = 0; j < subLength + (remainder > 0 ? 1 : 0); j++) {
                    prev = dummy;
                    dummy = dummy.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
                remainder--;
            }
            return ans;
        }

        private int getLength(ListNode root) {
            int length = 0;
            while (root != null) {
                root = root.next;
                ++length;
            }
            return length;
        }
    }
}
