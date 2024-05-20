/**
 * Vector 為一可置入"任意物件"的"動態陣列"(可隨內含物多寡增減其長度)
 * Vector 提供同步化的優點(與負擔) , 這對多執行緒的存取是很重要的
 */
package se.ex2.david.additional;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestVector_Enumeration {
    public static void main(String[] args) {
        Vector list = new Vector();
        list.add(Integer.valueOf(12));
        list.add(Long.valueOf(34L));
        list.add(new Float(5.6f));
        list.add(new Double(7.8));
        list.add("Hello");

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }

        // JDK1.2後,Vector也可以用Iterator取值.
        // 因為List家族可以用Iterator或for迴圈取值
        System.out.println();
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println(); // 或再利用JDK 1.5 的for-each取值
        for (Object value : list)
            System.out.println(value);

        // 其它方法取值1 -> toArray()
        System.out.println();
        Object[] a = list.toArray();
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        // JDK 1.0其它方法取值2 -> elements()
        // 只有 Vector 才有此method, 故呼叫此method時不能用多型的寫法
        System.out.println();
        Enumeration en = list.elements();
        while (en.hasMoreElements())
            System.out.println(en.nextElement());

    }
}
