package leecode.easy;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No21 {
    /**
     * 形象地理解，這個算法的邏輯類似於拉拉鏈，l1, l2 類似於拉鏈兩側的鋸齒，指針 p 就好像拉鏈的拉索，
     * 將兩個有序鏈表合併
     *
     * 代碼中還用到一個鏈表的算法題中是很常見的「虛擬頭結點」技巧，也就是 dummy 節點。
     * 你可以試試，如果不使用 dummy 虛擬節點，代碼會覆雜很多，而有了 dummy 節點這個占位符，可以避免處理空指針的情況，降低代碼的覆雜性。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = new ListNode(-1);
        ListNode p =first;
        ListNode p1 = list1,p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p=p.next;
        }
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return first.next;
    }

}
// Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {
//    }
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
