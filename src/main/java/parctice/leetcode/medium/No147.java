package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author m1a2st
 * @Date 2023/4/14
 * @Version v1.0
 */
public class No147 {

    @Test
    public void test() {
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        SolutionNew solutionNew = new SolutionNew();
        ListNode listNode = solutionNew.insertionSortList(a);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {
        public static ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = head;
            PriorityQueue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(s -> s.val));
            while (dummy != null) {
                listNodes.add(dummy);
                dummy = dummy.next;
            }
            ListNode res = new ListNode(-1);
            ListNode ret = res;
            while (!listNodes.isEmpty()) {
                res.next = listNodes.poll();
                res = res.next;
            }
            res.next = null;
            return ret.next;
        }
    }

    class SolutionNew {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            while (head != null) {
                ListNode temp = head.next;

                if (prev.val >= head.val) {
                    prev = dummy;
                }

                while (prev.next != null && prev.next.val < head.val) {
                    prev = prev.next;
                }
                // 把大於 head.val 的所有節點加到 head 後面
                head.next = prev.next;
                // 把 head 加到 prev 後面
                prev.next = head;
                // head 繼續往下一個節點
                head = temp;
            }
            return dummy.next;
        }
    }
}
