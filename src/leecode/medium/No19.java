
package leecode.medium;

public class No19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        Solution.removeNthFromEnd(head, 2);
    }

    static class SolutionOld {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head);
            ListNode x = findFromEnd(dummy, n);
            x.next = x.next.next;
            return dummy.next;
        }

        private static ListNode findFromEnd(ListNode dummy, int i) {
            int len = 1;
            ListNode temp = dummy.next;
            while (temp.next != null) {
                temp = temp.next;
                len++;
            }
            int deleteIndex = len - i;
            for (int j = 0; j < deleteIndex; j++) {
                dummy = dummy.next;
            }
            return dummy;
        }
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 找到要刪除的前一個節點
            ListNode node = findRemoveNode(dummy, n + 1);
            node.next = node.next.next;
            return dummy.next;
        }

        private static ListNode findRemoveNode(ListNode dummy, int i) {
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int j = 0; j < i; j++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode x = findFromEnd(dummy, n + 1);
//        x.next = x.next.next;
//        return dummy.next;
//    }
//
//    private ListNode findFromEnd(ListNode head, int j) {
//        ListNode tmp = head;
//        for (int i = 0; i < j; i++) {
//            tmp = tmp.next;
//        }
//        ListNode temp = head;
//        while (tmp != null) {
//            tmp = tmp.next;
//            temp = temp.next;
//        }
//        return temp;
//    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode x = findFromEnd(dummy,n+1);
//        x.next = x.next.next;
//        return dummy.next;
//    }
//
//    private ListNode findFromEnd(ListNode head,int index){
//        ListNode temp = head;
//        for (int i = 0; i < index; i++) {
//            temp = temp.next;
//        }
//        ListNode temp2 = head;
//        while(temp != null){
//            temp = temp.next;
//            temp2= temp2.next;
//        }
//        return temp2;
//    }
}
