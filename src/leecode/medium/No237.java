package leecode.medium;

public class No237 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(3);
        list.push(4);
        list.unshift(5);
        list.printAll();

    }

    public void deleteNode(Listnode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class Listnode {
    int val;
    Listnode next;

    Listnode(int x) {
        this.val = x;
        this.next = null;
    }
}

class LinkedList {
    int length;
    Listnode head;

    public LinkedList() {
    }

    public LinkedList(int length, Listnode head) {
        this.length = length;
        this.head = head;
    }

    public void push(int val) {
        Listnode newNode = new Listnode(val);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Listnode currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        this.length++;
    }

    public void unshift(int val) {
        if (this.head == null) {
            this.head = new Listnode(val);
        } else {
            Listnode temp = this.head;
            Listnode newNode = new Listnode(val);
            this.head = newNode;
            this.head.next = temp;
        }
        length++;
    }

    public Listnode pop() {
        if (this.head == null) {
            return null;
        } else if (this.length == 1) {
            Listnode temp = this.head;
            this.head = null;
            length = 0;
            return temp;
        } else {
            Listnode currentNode = this.head;
            for (int i = 1; i <= length - 2; i++) {
                currentNode = currentNode.next;
            }
            Listnode temp = currentNode.next;
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

    public Listnode shift() {
        if (this.head == null) {
            return null;
        } else if (this.length == 1) {
            Listnode temp = this.head;
            this.head = null;
            this.length = 0;
            return temp;
        } else {
            Listnode temp = this.head;
            this.head = this.head.next;
            this.length--;
            return temp;
        }
    }

    public void printAll() {
        if (this.length == 0) {
            System.out.println("Nothing in this linked list");
        }
        Listnode currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
}