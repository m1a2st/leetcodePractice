package leecode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No138 {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static class Solution {
        Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (!map.containsKey(head)) {
                Node newHead = new Node(head.val);
                map.put(head, newHead);
                newHead.next = copyRandomList(head.next);
                newHead.random = copyRandomList(head.random);
            }
            return map.get(head);
        }
    }
}
