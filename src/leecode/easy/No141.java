package leecode.easy;

import leecode.medium.ListNode;

public class No141 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head ,slow = head;
            while(fast != null && slow.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
