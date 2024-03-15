package leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/3/26
 * @Version v1.0
 */
public class No82 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        Solution.deleteDuplicates(head);
    }

    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            while (head != null){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                if(pre.next == head){
                    pre = pre.next;
                }else{
                    pre.next = head.next;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
