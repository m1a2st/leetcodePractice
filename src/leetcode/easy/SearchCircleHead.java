package leetcode.easy;

import leetcode.medium.ListNode;

public class SearchCircleHead {
    /**
     * 我們假設快慢指針相遇時，慢指針 slow 走了 k 步，那麽快指針 fast 一定走了 2k 步。
     * fast 一定比 slow 多走了 k 步，這多走的 k 步其實就是 fast 指針在環里轉圈圈，所以 k 的值就是環長
     * 度的「整數倍」。
     *
     * 假設相遇點距環的起點的距離為 m，那麽結合上圖的 slow 指針，環的起點距頭結點 head 的距離為 k - m，
     * 也就是說如果從 head 前進 k - m 步就能到達環起點。
     * 巧的是，如果從相遇點繼續前進 k - m 步，也恰好到達環起點。因為結合上圖的 fast 指針，從相遇點開始走
     * k步可以轉回到相遇點，那走 k - m 步肯定就走到環起點了
     * @param head 開始的頭節點
     * @return 環形鏈表的起點
     */
    ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if( fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
