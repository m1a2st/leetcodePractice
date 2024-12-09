package parctice.leetcode.medium;

public class No707 {


    class MyLinkedList {

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head;
        Node tail;

        public MyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            Node cur = head.next;
            while (cur != null && index > 0) {
                cur = cur.next;
                index -= 1;
            }
            if (cur != null && cur != tail && index == 0) {
                return cur.val;
            }
            return -1;
        }

        public void addAtHead(int val) {
            addNode(val, head.next);
        }

        public void addAtTail(int val) {
            addNode(val, tail);
        }

        private void addNode(int val, Node temp) {
            Node node = new Node(val);
            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp.prev = node;
        }

        public void addAtIndex(int index, int val) {
            Node temp = head.next;
            while (temp != null && index > 0) {
                temp = temp.next;
                index -= 1;
            }
            if (temp != null && index == 0) {
                addNode(val, temp);
            }
        }

        public void deleteAtIndex(int index) {
            Node temp = head.next;
            while (temp != null && index > 0) {
                temp = temp.next;
                index -= 1;
            }
            if (temp != null && temp != tail && index == 0) {
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            }
        }
    }
}
