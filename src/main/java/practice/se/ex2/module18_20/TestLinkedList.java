/**
 * LinkedList 也是一可置入"任意物件"的"動態陣列"(可隨內含物多寡增減其長度)
 * 如果你需要經常將元素插入和刪除的話 , 那麼 LinkedList 可以有更佳的效率
 * LinkedList 多了 void addFirst(Object o); void addLast(Object o);
 * Object getFirst();       Object getLast(); 等方法
 */

package practice.se.ex2.module18_20;

import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(Integer.valueOf(12));
        list.add(Long.valueOf(34L));
        list.add("Hello");
        list.add("Hello"); // duplicate, is added

        System.out.println("toString()=" + list);
        System.out.println("元素個數=" + list.size());

        Iterator objs = list.iterator();
        while (objs.hasNext())
            System.out.println(objs.next());

        // List家族可以用Iterator或for迴圈取值
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }

        // 其它方法取值1 -> toArray()
        System.out.println();
        Object[] a = list.toArray();
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        // 只有 LinkedList 才有此addFirst()...等method, 故呼叫此等method時不能用多型的寫法
        System.out.println();
        list.addFirst("first");
        list.addLast("last");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }
}
