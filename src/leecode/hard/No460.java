package leecode.hard;

import java.util.HashMap;
import java.util.Map;

public class No460 {

    class LFUCache {

        Map<Integer, Node> cache = new HashMap<>();
        int capacity, size;
        Node head;
        Node tail;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            removeToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    Node leastFreqNode = removeLeastFreqNode();
                    cache.remove(leastFreqNode.key);
                    size--;
                }
            } else {
                node.value = value;
                removeToHead(node);
            }
        }

        class Node {
            int key;
            int value;
            int freq;
            Node next;
            Node prev;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            ++node.freq;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void removeLast() {
            removeNode(tail.prev);
        }

        public void removeToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private Node removeLeastFreqNode() {
            Node pNode = head.next.next;
            int tempFreq = tail.prev.freq;
            while (pNode != null && pNode.value > 0) {
                if (pNode.freq < tempFreq) {
                    tempFreq = pNode.freq;
                }
                pNode = pNode.next;
            }
            pNode = tail.prev;
            while (pNode.freq > 0 && pNode.freq != tempFreq) {
                pNode = pNode.prev;
            }
            removeNode(pNode);
            return pNode;
        }
    }
}
