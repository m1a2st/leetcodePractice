package parctice.leetcode.data_structure.queue;

import java.util.Scanner;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //test
        //創建測試對象，設置4，其隊列的有效數據最大為3
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 顯示隊列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加數據到隊列");
            System.out.println("g(get): 從隊列取出數據");
            System.out.println("h(head): 查看隊列頭數據");
            key = scanner.next().charAt(0); //接收一個字符
            switch (key) {
                case 's' -> queue.show();
                case 'a' -> {
                    System.out.println("請輸入一個數：");
                    int value = scanner.nextInt();
                    queue.push(value);
                }
                case 'g' -> {
                    try {
                        int pop = queue.pop();
                        System.out.printf("取出的數據為%d\n", pop);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 'h' -> {
                    try {
                        int peek = queue.peek();
                        System.out.printf("隊列頭的數據是%d\n", peek);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 'e' -> loop = false;
            }
        }
        System.out.println("程序退出");
    }
}


//使用陣列模擬隊列 - 編寫一個CircleArrayQueue類
class CircleArrayQueue {
    // 表示陣列最大容量
    private final int maxSize;
    // front 變量含義做一個調整： front 就指向隊列的第一個元素，也就是說 arr[front]
    // front 的初始值 = 0
    private int front;
    //rear 變量含義做一個調整： rear 就指向隊列的最後一個元素的後一個位置，因為希望空出一個位置
    //rear 的初始值 = 0
    private int rear;
    private final int[] arr; // 該陣列用於存放數據，模擬陣列

    //創建隊列構造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判斷隊列是否滿
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    //判斷對列是否為空
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    //添加數據到隊列
    public void push(int value) {
        //判斷隊列是否滿
        if (isFull()) {
            System.out.println("Queue is full, cant input message");
            return;
        }
        //直接加入數據
        this.arr[rear] = value;
        //將rear後移，這裡必需考慮前面是否還有空間
        this.rear = (this.rear + 1) % this.maxSize;
    }

    //獲取隊列數據
    public int pop() throws RuntimeException {
        if (isEmpty()) {
            //通過拋出異常處理
            throw new RuntimeException("Queue is empty");
        }
        //這裡需要分析出 front是指向隊列第一個元素
        /*
            1. 先把front對應的值保留到一個臨時變量
            2. 將front後移，考慮是否會超出陣列
            3. 將臨時保存的變量返回
         */
        int value = arr[front];
        this.front = (this.front + 1) % maxSize;
        return value;
    }

    //顯示隊列數據
    public void show() {
        //遍歷
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        // 思路： 從front開始遍歷，遍歷多少個元素
        for (int i = front; i < front + this.size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出當前隊列有效數據個數
    public int size() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    //顯示隊列的頭數據，不是取出數據
    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
}
