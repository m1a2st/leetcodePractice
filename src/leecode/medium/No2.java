package leecode.medium;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;
        int sum = 0;
        int h = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + h;
            } else if (l1 == null) {
                sum = l2.val + h;
            } else {
                sum = l1.val + h;
            }
            if (sum > 9) {
                node.val = sum % 10;
                h = 1;
            } else {
                node.val = sum;
                h = 0;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            if (l1 != null || l2 != null) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        if (h == 1) {
            node.next = new ListNode();
            node.next.val = 1;
        }
        return head;
    }
}

