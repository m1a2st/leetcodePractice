package leecode.easy;

public class No876 {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head,temp2 = head;
        while(temp2 != null && temp2.next != null){
            temp = temp.next;
            temp2 = temp2.next.next;
        }
        return temp;
    }
}
