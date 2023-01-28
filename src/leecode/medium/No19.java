
package leecode.medium;

public class No19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int j) {
        ListNode tmp = head;
        for (int i = 0; i < j; i++) {
            tmp = tmp.next;
        }
        ListNode temp = head;
        while(tmp != null){
            tmp = tmp.next;
            temp = temp.next;
        }
        return temp;
    }

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
