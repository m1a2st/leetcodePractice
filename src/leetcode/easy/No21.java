package leetcode.easy;

import leetcode.medium.ListNode;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No21 {

    static class SolutionOld {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode merge = new ListNode(-1);
            ListNode p = merge;
            ListNode p1 = list1;
            ListNode p2 = list2;
            while (p1 != null && p2 != null) {
                if (p1.val >= p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return merge.next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode merge = new ListNode(-1);
            ListNode p = merge;
            while (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    p.next = list2;
                    list2 = list2.next;
                } else {
                    p.next = list1;
                    list1 = list1.next;
                }
                p = p.next;
            }
            if (list1 != null) {
                p.next = list1;
            }

            if (list2 != null) {
                p.next = list2;
            }
            return merge.next;
        }
    }

    /**
     * 形象地理解，這個算法的邏輯類似於拉拉鏈，l1, l2 類似於拉鏈兩側的鋸齒，指針 p 就好像拉鏈的拉索，
     * 將兩個有序鏈表合併
     * <p>
     * 代碼中還用到一個鏈表的算法題中是很常見的「虛擬頭結點」技巧，也就是 dummy 節點。
     * 你可以試試，如果不使用 dummy 虛擬節點，代碼會覆雜很多，而有了 dummy 節點這個占位符，可以避免處理空指針的情況，降低代碼的覆雜性。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = new ListNode(-1);
        ListNode p = first;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return first.next;
    }

}
