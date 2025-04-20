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

        private final int capacity;
        private final Set<Node> cache = new LinkedHashSet<>();
        private final Map<Integer, Node> keyToNode = new HashMap<>();

        public LRUCacheNew(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyToNode.containsKey(key)) {
                return -1;
            }
            Node node = keyToNode.get(key);
            cache.remove(node);
            cache.add(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (keyToNode.containsKey(key)) {
                keyToNode.get(key).value = value;
                get(key);
                return;
            }
            if (cache.size() == capacity) {
                Node lastNode = cache.iterator().next();
                cache.remove(lastNode);
                keyToNode.remove(lastNode.key);
            }
            Node node = new Node(key, value);
            cache.add(node);
            keyToNode.put(key, node);
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
