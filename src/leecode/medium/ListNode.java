package leecode.medium;

/**
 * @Author m1a2st
 * @Date 2023/4/14
 * @Version v1.0
 */

//  Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        traverse(head);
    }

    void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        traverse(head.next);
        // 后序位置
    }
}

