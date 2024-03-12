package leecode.medium;

import java.util.HashMap;
import java.util.Map;

public class No1171 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur != null) {
                int sum = 0;
                ListNode curNext = cur.next;
                while (curNext != null) {
                    sum += curNext.val;
                    if (sum == 0) {
                        cur.next = curNext.next;
                    }
                    curNext = curNext.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    class SolutionMap {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            int prefixSum = 0;
            Map<Integer, ListNode> map = new HashMap<>();
            map.put(prefixSum, dummy);
            while (head != null) {
                prefixSum += head.val;
                map.put(prefixSum, head);
                head = head.next;
            }
            head = dummy;
            prefixSum = 0;
            while (head != null) {
                prefixSum += head.val;
                head.next = map.get(prefixSum).next;
                head = head.next;
            }
            return dummy.next;
        }
    }
}
