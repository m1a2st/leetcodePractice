package leetcode.data_structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @Author Ken Huang
 * @Date 2022/11/25
 * @Version v1.1
 * @Description refactor
 */
public class PolandNotationDemo {
    public static void main(String[] args) {
        Transform transform = new Transform();
        String expression = "1+((2+3)*4)-5";
        List<String> poland = transform.polandTransfer(expression);
        System.out.println(PolandCalculate.calculate(poland));
    }
}
//完成對中綴表達式字串，轉換成逆波蘭表達式陣列
class Transform {
    /**
     * 將中綴表達式轉成後綴表達式的功能
     * 說明 :
     * 1. 1 + ( ( 2 + 3 ) × 4) - 5 => 1 2 3 + 4 * + 5 -
     * 2. 因為直接對String進行操作不方便，因此先將String轉換成中綴表達式對應的List
     *    即 1 + ( ( 2 + 3 )× 4) - 5 => ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
     * 3. 將得到的中綴表達式對應的list => 後綴表達式的list
     *    即 ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList [1, 2, 3, +, 4, *, +, 5, -]
     * @param expression 四則運算算式
     * @return 逆波蘭表達式陣列
     */
    public List<String> polandTransfer(String expression) {
        List<String> polandList;
        List<String> infixList = toInfixExpressionList(expression);
        polandList = parseSuffixExpressionList(infixList);
        return polandList;
    }

    /**
     * 可以將中綴表達式轉換成中綴表達式陣列
     *
     * @param expression 中綴表達式的四則運算方法
     * @return 中綴表達式的陣列
     */
    private List<String> toInfixExpressionList(String expression) {
        ArrayList<String> infixExpression = new ArrayList<>();
        int index = 0; // 指針，用於遍歷中綴表達式字符串
        StringBuilder str; //多位數拼接工作
        char ch; //每遍歷到一個字符，就放到ch中
        do {
            if (isNumber(ch = expression.charAt(index))) {
                str = new StringBuilder();
                while (index < expression.length() && isNumber(ch = expression.charAt(index))) {
                    str.append(ch);
                    index++;
                }
                infixExpression.add(str.toString());
            } else {
                infixExpression.add("" + ch);
                index++;
            }
        } while (index < expression.length());
        return infixExpression;
    }

    /**
     * 將中綴表達式轉換成逆波蘭表達式（都是使用list）
     * 1. 遇到運算符時，比較其與operStack棧頂運算符的優先級：
     * 1. 如果operStack為空，或棧頂運算符為左括號“(”，則直接將此運算符入棧；
     * 2. 否則，若優先級比棧頂運算符的高，也將運算符壓入operStack；
     * 3. 否則，將s1棧頂的運算符彈出並壓入到polandNotation中，再次轉到(1)與operStack中新的棧頂運算符相比較；
     * 2. 遇到括號時：
     * 1. 如果是左括號“(”，則直接壓入operStack
     * 2. 如果是右括號“)”，則依次彈出operStack棧頂的運算符，並壓入polandNotation，直到遇到左括號為止，此時將這一對括號丟棄
     * 3. 將operStack中剩餘的運算符依次彈出並壓入polandNotation
     * ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList [1, 2, 3, +, 4, *, +, 5, -]
     *
     * @param infixExpression 中綴表達式
     * @return 逆波蘭表達式
     */
    private List<String> parseSuffixExpressionList(List<String> infixExpression) {
        /*
            定義兩個棧（符號棧，存取中間結果的棧）
            因為polandNotation這個棧，在轉換的過程中並沒有pop操作，而且後面還需要逆向輸出
            因此比較麻煩，這裡就不使用Stack直接使用List
         */
        Stack<String> operStack = new Stack<>();
        List<String> polandNotation = new ArrayList<>();
        for (String item : infixExpression) {
            if (item.matches("\\d+")) {
                polandNotation.add(item);
            } else if ("(".equals(item)) {
                operStack.push(item);
            } else if (")".equals(item)) {
                //如果是右括號“)”，則依次彈出s1棧頂的運算符，並壓入s2，直到遇到左括號為止，此時將這一對括號丟棄
                while (!"(".equals(operStack.peek())) {
                    polandNotation.add(operStack.pop());
                }
                //將(彈出operStack，消除小括號
                operStack.pop();
            } else {
                /*
                   當item的優先級，小於棧頂的優先級
                   將operStack棧頂的運算符彈出並加入到resultArray中，再次與operStack棧頂的運算符相比較
                */
                while (operStack.size() != 0 && checkOperPiority(operStack.peek(),item)) {
                    polandNotation.add(operStack.pop());
                }
                //還需要將item 壓入棧中
                operStack.push(item);
            }
        }
        //將operStack中剩餘的運算符依次彈出並壓入polandNotation
        while (operStack.size() != 0) {
            polandNotation.add(operStack.pop());
        }
        return polandNotation;
    }

    /**
     * 判斷兩個運算符號誰的優先級比較大，若是前者回傳true，後者回傳false
     * Example :
     * checkOperPiority("*","/") => true
     * checkOperPiority("*","-") => true
     * checkOperPiority("-","/") => false
     * checkOperPiority("+","/") => false
     * checkOperPiority("+","-") => true
     * @param operStackOper 符號棧棧頂的運算符
     * @param suffixOper 中綴表達式中的運算符
     * @return 符號棧棧頂的運算符優先度是否大於中綴表達式中的運算符
     */
    private boolean checkOperPiority(String operStackOper, String suffixOper){
        return PolandOperation.getValue(operStackOper) >= PolandOperation.getValue(suffixOper);
    }

    /**
     * 判斷此字元是不是數字，運用AscCode來進行判斷
     *
     * @param ch 想要進行判斷的字元
     * @return 是否為數字
     */
    private boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

}


//完成對逆波蘭表達式的運算
class PolandCalculate {

    /**
     * - 例如: (3+4)×5-6 對應的後綴表達式就是 3 4 + 5 × 6 - , 針對後綴表達式求值步驟如下:
     * 1. 從左至右掃描，將3和4壓入堆棧；
     * 2. 遇到+運算符，因此彈出4和3（4為棧頂元素，3為次頂元素），計算出3+4的值，得7，再將7入棧；
     * 3. 將5入棧；
     * 4. 接下來是×運算符，因此彈出5和7，計算出7×5=35，將35入棧；
     * 5. 將6入棧；
     * 6. 最後是-運算符，計算出35-6的值，即29，由此得出最終結果
     *
     * @param expressionList 逆波蘭表達式
     * @return 運算結果
     */
    public static int calculate(List<String> expressionList) {
        Stack<String> expression = new Stack<>();
        for (String ele : expressionList) {
            //使用正則表達式取出數字，匹配的是多位數
            if (ele.matches("\\d+")) {
                expression.push(ele);
            } else {
                //pop出兩個數，並運算，在入棧
                int num1 = Integer.parseInt(expression.pop());
                int num2 = Integer.parseInt(expression.pop());
                int result = cal(num1, num2, ele);
                expression.push("" + result);
            }
        }
        //最後留在stack中的數據就是運算結果
        return Integer.parseInt(expression.pop());
    }

    /**
     * 計算加減乘除
     *
     * @param num1 運算數
     * @param num2 被運算數
     * @param oper 運算符
     * @return 運算結果
     */
    private static int cal(int num1, int num2, String oper) {
        int result;
        switch (oper) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num2 - num1;
            case "*" -> result = num1 * num2;
            case "/" -> result = num2 / num1;
            default -> throw new RuntimeException("Operation has error.");
        }
        return result;
    }
}


//編寫Operation類，可以返回一個運算符對應的優先級
class PolandOperation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    //寫一個方法，返回對應的優先級數字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+" -> result = ADD;
            case "-" -> result = SUB;
            case "*" -> result = MUL;
            case "/" -> result = DIV;
            default -> System.out.println("This operation is invalid.");
        }
        return result;
    }
}
