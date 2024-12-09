package parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No706 {

    class MyHashMap {

        Bucket[] buckets;
        int hashKey;

        public MyHashMap() {
            hashKey = 736;
            buckets = new Bucket[736];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new Bucket();
            }
        }

        private int hash(int key) {
            return key % hashKey;
        }

        public void put(int key, int value) {
            int hashKey = hash(key);
            buckets[hashKey].put(key, value);
        }

        public int get(int key) {
            int hashKey = hash(key);
            return buckets[hashKey].get(key);
        }

        public void remove(int key) {
            int hashKey = hash(key);
            buckets[hashKey].remove(key);
        }

        class Pair<K, V> {
            K key;
            V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        class Bucket {
            List<Pair<Integer, Integer>> paris;

            public Bucket() {
                this.paris = new ArrayList<>();
            }

            public Integer get(Integer key) {
                for (Pair<Integer, Integer> pair : paris) {
                    if (pair.key.equals(key)) {
                        return pair.value;
                    }
                }
                return -1;
            }

            public void put(Integer key, Integer value) {
                boolean found = false;
                for (Pair<Integer, Integer> pair : paris) {
                    if (pair.key.equals(key)) {
                        pair.value = value;
                        found = true;
                    }
                }
                if (!found) {
                    paris.add(new Pair<>(key, value));
                }
            }

            public void remove(Integer key) {
                for (Pair<Integer, Integer> pair : paris) {
                    if (pair.key.equals(key)) {
                        paris.remove(pair);
                        break;
                    }
                }
            }
        }
    }

    class MyHashMapNew {

        static final int MOD = 19997;

        ListNode[] buckets;

        public MyHashMapNew() {
            this.buckets = new ListNode[MOD];
        }

        public void put(int key, int value) {
            remove(key);
            int h = hash(key);
            ListNode node = new ListNode(key, value, buckets[h]);
            buckets[h] = node;
        }

        public int get(int key) {
            int h = hash(key);
            ListNode node = buckets[h];
            while (node != null) {
                if (node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            ListNode node = buckets[h];
            if (node == null) {
                return;
            }
            if (node.key == key) {
                buckets[h] = node.next;
                return;
            }
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        private int hash(int key) {
            return Integer.hashCode(key) % MOD;
        }

        class ListNode {
            int key;
            int val;
            ListNode next;

            public ListNode(int key, int val, ListNode next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
    }
}
