package main.java.parctice.leetcode.medium;

public class No622 {

    class MyCircularQueue {
        private final int[] queue;
        // 用來維持頭部的索引
        private int headIndex;
        // 用來維持目前的長度
        private int count;
        // 用來記錄容量
        private final int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.headIndex = 0;
            this.count = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[(headIndex + count) % capacity] = value;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            headIndex = (headIndex + 1) % capacity;
            count--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[headIndex];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[(headIndex + count - 1) % capacity];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == capacity;
        }
    }
}
