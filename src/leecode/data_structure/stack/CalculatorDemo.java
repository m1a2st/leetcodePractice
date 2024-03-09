package leecode.data_structure.stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        //根據思路，完成表達式運算
        String expression = "720+6*2-4";
        Calculator calculator = new Calculator();
        calculator.calculate(expression);
    }
}

class Calculator {

    //創建二個棧，一個數棧，一個符號棧
    private final ArrayStackCal numberStack;
    private final ArrayStackCal operStack;

    public Calculator() {
        numberStack = new ArrayStackCal(10);
        operStack = new ArrayStackCal(10);
    }

    /**
     * 計算使用者輸入的運算式，並顯示出運算結果
     * @param expression 四則運算算式
     */
    public void calculate(String expression) {
        int num1;
        int num2;
        int result;
        char ch;//將每次掃描的char保存到ch
        char oper;
        StringBuilder keepNumber = new StringBuilder(); //多位數會用到
        Operation operation = new Operation();
        Calculate calculate = new Calculate();

        //掃描expression
        for (int index = 0; index < expression.length(); index++) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判斷目前字元數否為數字
            if (operation.isOper(ch)) {
                /*
                    分析思路
                    1. 判斷符號棧是否為空，若為空則直接入棧
                    2. 如果符號棧有操作符，就進行比較,如果當前的操作符的優先級小於或者等於棧中的操作符， 就需要從數棧中pop出兩個數,
                       在從符號棧中pop出一個符號，進行運算，將得到結果，入數棧，然後將當前的操作符入符號棧
                    3. 如果當前的操作符的優先級大於棧中的操作符， 就直接入符號棧
                 */
                if (!operStack.isEmpty()) {
                    if (operation.priority(ch) <= operation.priority((char) operStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = (char) operStack.pop();
                        result = calculate.cal(num1, num2, oper);
                        numberStack.push(result);
                    }
                }
                operStack.push(ch);
            } else {
                /*
                    分析思路
                    1. 當處理多位數時，不能發現一個數就立即入棧，因為可能是多位數
                    2. 當處理數，需要向expression表達式的index後看一位，如果是數就進行掃描，如果是符號才入坑
                    3. 因此我們需要定義一個變量 字符串，用於拼接
                 */
                keepNumber.append(ch);
                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(keepNumber.toString()));
                } else {
                    if (operation.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numberStack.push(Integer.parseInt(keepNumber.toString()));
                        keepNumber = new StringBuilder();
                    }
                }
            }
        }
        //當表達式掃描完畢，就順序的從 數棧和符號棧中pop出相應的數和符號，並運行
        while (!operStack.isEmpty()) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = (char) operStack.pop();
            result = calculate.cal(num1, num2, oper);
            numberStack.push(result);
        }
        System.out.printf("Expression %s = %d\n", expression, numberStack.pop());
    }
}

//定義一個ArrayStackCal表示棧
class ArrayStackCal {
    //棧的大小
    private final int maxSize;
    //陣列模擬棧，數據放在該陣列
    private int[] stack;
    //top表示棧頂，初始化為-1
    private int top = -1;

    public ArrayStackCal(int maxSize) {
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

    //顯示當前棧頂的值
    public int peek() {
        return stack[top];
    }
}

//運算符號定義類
class Operation {

    //返回運算符的優先級，優先級由程式設計師來決定，優先級使用數字表示
    /**
     * 數字越大，則運算符的優先級越高
     *
     * @param oper 運算符
     * @return 此運算符的優先級
     */
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; //假定目前運算符只有'+','-','*','/'
        }
    }

    /**
     * 判斷是不是一個運算符
     *
     * @param oper 將要判斷的字元
     * @return 判斷這個符號是不是合法的運算符號
     */
    public boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }
}

//計算加減乘除
class Calculate {
    //計算方法
    public int cal(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+' -> result = num2 + num1;
            case '-' -> result = num2 - num1;
            case '*' -> result = num2 * num1;
            case '/' -> result = num2 / num1;
        }
        return result;
    }
}
