package leecode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author m1a2st
 * @Date 2023/4/14
 * @Version v1.0
 */
public class No147 {

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution.insertionSortList(a);
    }

    static class Solution {
        public static ListNode insertionSortList(ListNode head) {
            if( head == null || head.next == null) return head;
            ListNode dummy = head;
            PriorityQueue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(s -> s.val));
            while (dummy != null) {
                listNodes.add(dummy);
                dummy = dummy.next;
            }
            ListNode res = new ListNode(-1);
            ListNode ret = res;
            while(listNodes.size() != 0){
                res.next = listNodes.poll();
                res = res.next;
            }
            res.next = null;
            return ret.next;
        }
    }
}
