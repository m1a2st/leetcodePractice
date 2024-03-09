package leecode.data_structure.queue;

import java.util.Scanner;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //test
        //創建測試對象
        ArrayQueue queue = new ArrayQueue(3);
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

//使用陣列模擬隊列 - 編寫一個ArrayQueue類
class ArrayQueue {
    private final int maxSize; //表示陣列最大容量
    private int front; //隊列頭
    private int rear; //隊列尾
    private int[] arr; // 該陣列用於存放數據，模擬陣列

    //創建隊列構造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.front = -1; //指向隊列頭部，分析出front是指向隊列頭的前一個位置
        this.rear = -1; //指向對列尾，指向對列尾數據（即就是對列最後一個數據）
    }

    //判斷隊列是否滿
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
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
        //rear 後移
        rear++;
        this.arr[rear] = value;
    }

    //獲取隊列數據
    public int pop() throws RuntimeException {
        if (isEmpty()) {
            //通過拋出異常處理
            throw new RuntimeException("Queue is empty");
        }
        front++;
        return arr[front];
    }

    //顯示隊列數據
    public void show() {
        //遍歷
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = 0; i < this.maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //顯示隊列的頭數據，不是取出數據
    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front + 1];
    }
}
