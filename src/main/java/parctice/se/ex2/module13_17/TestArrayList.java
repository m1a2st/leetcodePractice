package main.java.parctice.se.ex2.module13_17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List list = new ArrayList();
        //JDK 5以前要手動裝箱才能加入集合裡
        list.add(Integer.valueOf(12)); //list.add(12)
        list.add(Long.valueOf(34L));   //list.add(Long.valueOf(34L))
        list.add(new Double(5.6));
        list.add("Hello");
        list.add("Hello"); // 值重覆仍加入到集合裡

        System.out.println("toString()=" + list);  //集合類別的toString方法都改寫過了(方便觀察用)
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
    }

}
