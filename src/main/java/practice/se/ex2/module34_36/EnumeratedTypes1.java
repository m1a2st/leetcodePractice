package practice.se.ex2.module34_36;

/*
 將數個參考值或名稱集合在一起。
 這種集合的方法，並不是陣列，也不屬於容器。通常我們之它為列舉：
 enum Month 是一個類別，姑且可稱之為列舉類別。
 -列舉本身就是一種型別
 -從 getClass() 中即可看出來是個類別，。 
 */

enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}

public class EnumeratedTypes1 {
    public static void main(String[] args) {

        for (Month xx : Month.values()) { // 增強式的 for 迴圈
            System.out.print(xx + " ");
        }

        System.out.println();

        Month yy = Month.JAN;
        System.out.println(yy); // JAN , 列舉子的值其實是它本身的名稱

        System.out.println(yy.getClass()); // class Month
    }
}
