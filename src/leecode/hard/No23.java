package leecode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,Comparator.comparingInt(s -> s.val));
        for (ListNode head : lists) {
            if(head != null){
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            p.next = poll;
            if(poll.next != null){
                pq.add(poll.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}

//  Definition for singly-linked list.
class ListNode {
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

