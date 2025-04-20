package practice.se.ex2.module13_17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(Integer.valueOf(12));
        set.add(Long.valueOf(34L));
        set.add("Hello");
        set.add("Hello"); // 值重覆不會加入

        System.out.println("toString()=" + set);
        System.out.println("元素個數=" + set.size());

        // Set家族只能用Iterator 取值
        Iterator objs = set.iterator();
        while (objs.hasNext())
            System.out.println(objs.next());

    }

}
