package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author m1a2st
 * @Date 2023/7/5
 * @Version v1.0
 */
public class No146 {

    @Test
    public void test() {
        LRUCacheNew cache = new LRUCacheNew(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }


    class LRUCacheNew {
        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int cap;
        HashMap<Integer, Node> m = new HashMap<>();

        public LRUCacheNew(int capacity) {
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node newnode) {
            Node temp = head.next;

            newnode.next = temp;
            newnode.prev = head;

            head.next = newnode;
            temp.prev = newnode;
        }

        private void deleteNode(Node delnode) {
            Node prevv = delnode.prev;
            Node nextt = delnode.next;

            prevv.next = nextt;
            nextt.prev = prevv;
        }

        public int get(int key) {
            if (m.containsKey(key)) {
                Node resNode = m.get(key);
                int ans = resNode.val;

                m.remove(key);
                deleteNode(resNode);
                addNode(resNode);

                m.put(key, head.next);
                return ans;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (m.containsKey(key)) {
                Node curr = m.get(key);
                m.remove(key);
                deleteNode(curr);
            }

            if (m.size() == cap) {
                m.remove(tail.prev.key);
                deleteNode(tail.prev);
            }

            addNode(new Node(key, value));
            m.put(key, head.next);
        }
    }

    class LRUCache {
        private final int capacity;
        // LinkedHashSet 是有順序性的，會依照插入順序做排列
        private final Set<Node> cache = new LinkedHashSet<>();
        private final Map<Integer, Node> keyToNode = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            // HashMap BigO 為 O(1)
            if (!keyToNode.containsKey(key))
                return -1;

            // 刷新列表
            Node node = keyToNode.get(key);
            cache.remove(node);
            // 加入最末尾
            cache.add(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (keyToNode.containsKey(key)) {
                keyToNode.get(key).value = value;
                // 刷新快取
                get(key);
                return;
            }

            if (cache.size() == capacity) {
                // 取出第一個元素
                Node lastNode = cache.iterator().next();
                // 移出快取表最開始加入的Node
                cache.remove(lastNode);
                // 移出對應map
                keyToNode.remove(lastNode.key);
            }
            // 加回去
            Node node = new Node(key, value);
            cache.add(node);
            keyToNode.put(key, node);
        }
    }

    class Node {
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
