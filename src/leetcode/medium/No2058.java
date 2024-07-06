package leetcode.medium;

import java.util.ArrayList;

public class No2058 {


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
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return new int[]{-1, -1};
            }
            ArrayList<Integer> cache = new ArrayList<>();
            ListNode preNode = head;
            ListNode curNode = head.next;
            ListNode nextNode = head.next.next;
            int index = 1;
            while (nextNode != null) {
                if (preNode.val < curNode.val && curNode.val > nextNode.val) {
                    cache.add(index);
                } else if (preNode.val > curNode.val && curNode.val < nextNode.val) {
                    cache.add(index);
                }
                preNode = curNode;
                curNode = nextNode;
                nextNode = nextNode.next;
                index++;
            }
            if (cache.size() < 2) {
                return new int[]{-1, -1};
            }
            int min = Integer.MAX_VALUE;
            int max = cache.get(cache.size() - 1) - cache.get(0);
            for (int i = 1; i < cache.size(); i++) {
                min = Math.min(min, cache.get(i) - cache.get(i - 1));
            }
            return new int[]{min, max};
        }
    }
}
