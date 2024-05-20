package leetcode.data_structure.stack;

import java.util.Scanner;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //創建一個ArrayStack實例
        ArrayStack arrayStack = new ArrayStack(4);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 顯示棧");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加數據到棧");
            System.out.println("g(get): 從棧取出數據");
            key = scanner.next().charAt(0); //接收一個字符
            switch (key) {
                case 's' -> arrayStack.list();
                case 'a' -> {
                    System.out.println("請輸入一個數：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                }
                case 'g' -> {
                    try {
                        int pop = arrayStack.pop();
                        System.out.printf("取出的數據為%d\n", pop);
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


//定義一個ArrayStack表示棧
class ArrayStack {
    //棧的大小
    private final int maxSize;
    //陣列模擬棧，數據放在該陣列
    private final int[] stack;
    //top表示棧頂，初始化為-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //棧滿
    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    //棧空
    public boolean isEmpty() {
        return top == -1;
    }

    //入棧-push
    public void push(int value) {
        //先判斷棧是否為滿
        if (isFull()) {
            System.out.println("This stack is Full.");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出棧-pop，將棧頂的數據返回
    public int pop() {
        //先判斷棧是否為空
        if (isEmpty()) {
            throw new RuntimeException("This stack is empty.");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //顯示棧的情況（遍歷棧），遍歷時，需要從棧頂顯示數據
    public void list() {
        if (isEmpty()) {
            System.out.println("This stack is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
