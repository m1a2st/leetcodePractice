package leecode.hard;

import leecode.medium.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(s -> s.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            p.next = poll;
            if (poll.next != null) {
                pq.add(poll.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            while (lists.length > 1) {
                ListNode[] newLists = new ListNode[(lists.length + 1) / 2];
                int j = 0;
                for (int i = 0; i < lists.length; i += 2) {
                    if (i + 1 < lists.length) {
                        newLists[j++] = mergeLists(lists[i], lists[i + 1]);
                    } else {
                        //odd number of lists
                        newLists[j++] = lists[i];
                    }
                }
                lists = newLists;
            }

            return lists[0];
        }


        public ListNode mergeLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (l2 != null && l1 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            current.next = (l2 == null) ? l1 : l2;

            return dummy.next;
        }
    }
}
