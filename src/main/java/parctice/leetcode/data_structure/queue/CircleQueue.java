package parctice.leetcode.data_structure.queue;

public class CircleQueue {

    // 表示陣列的最大容量
    private final int maxSize;
    private final int[] arr;
    // front 就指向隊列的第一個元素，也就是說 arr[front]
    private int front;
    // rear 就指向隊列的最後一個元素的後一個位置
    private int rear;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判斷對列是否為空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加數據到隊列
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("隊列已滿，無法加入數據");
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    // 獲取隊列數據
    public int pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("隊列為空，無法取出數據");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 顯示隊列數據
    public void show() {
        if (isEmpty()) {
            System.out.println("隊列為空，無法顯示數據");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出當前隊列有效數據個數
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 顯示隊列的頭數據，不是取出數據
    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("隊列為空，無法取出數據");
        }
        return arr[front];
    }
}

