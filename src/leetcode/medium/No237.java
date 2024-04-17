package leetcode.medium;

public class No237 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(3);
        list.push(4);
        list.unshift(5);
        list.printAll();

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    static class LinkedList {
        int length;
        ListNode head;

        public LinkedList() {
        }

        public LinkedList(int length, ListNode head) {
            this.length = length;
            this.head = head;
        }

        public void push(int val) {
            ListNode newNode = new ListNode(val);
            if (this.head == null) {
                this.head = newNode;
            } else {
                ListNode currentNode = this.head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
            this.length++;
        }

        public void unshift(int val) {
            if (this.head == null) {
                this.head = new ListNode(val);
            } else {
                ListNode temp = this.head;
                this.head = new ListNode(val);
                this.head.next = temp;
            }
            length++;
        }

        public ListNode pop() {
            if (this.head == null) {
                return null;
            } else if (this.length == 1) {
                ListNode temp = this.head;
                this.head = null;
                length = 0;
                return temp;
            } else {
                ListNode currentNode = this.head;
                for (int i = 1; i <= length - 2; i++) {
                    currentNode = currentNode.next;
                }
                ListNode temp = currentNode.next;
                currentNode.next = null;
                this.length--;
                return temp;
            }
        }

        public void removeAt(int index) {
            if (index > this.length - 1 || index < 0) {

            } else if (index == 0) {
                this.shift();
            } else if (index == this.length - 1) {
                this.pop();
            }
        }

        public ListNode shift() {
            if (this.head == null) {
                return null;
            } else if (this.length == 1) {
                ListNode temp = this.head;
                this.head = null;
                this.length = 0;
                return temp;
            } else {
                ListNode temp = this.head;
                this.head = this.head.next;
                this.length--;
                return temp;
            }
        }

        public void printAll() {
            if (this.length == 0) {
                System.out.println("Nothing in this linked list");
            }
            ListNode currentNode = this.head;
            while (currentNode != null) {
                System.out.println(currentNode.val);
                currentNode = currentNode.next;
            }
        }
    }
}
