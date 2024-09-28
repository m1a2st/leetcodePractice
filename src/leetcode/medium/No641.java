package leetcode.medium;

public class No641 {

    class MyCircularDeque {
        
        private final int capacity;
        private final int[] elements;
        private int size = 0;
        private int front = 0;
        private int rear;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.capacity = k;
            this.elements = new int[k];
            this.rear = k - 1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull())
                return false;
            front = (--front + capacity) % capacity;
            elements[front] = value;
            ++size;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull())
                return false;

            rear = ++rear % capacity;
            elements[rear] = value;
            ++size;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty())
                return false;

            front = ++front % capacity;
            --size;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty())
                return false;
            rear = (--rear + capacity) % capacity;
            --size;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : elements[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : elements[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == capacity;
        }
    }

}
