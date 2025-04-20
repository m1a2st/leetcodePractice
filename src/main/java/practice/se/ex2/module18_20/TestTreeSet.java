package practice.se.ex2.module18_20;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(Integer.valueOf(56));
        set.add(Integer.valueOf(34));
        set.add(Integer.valueOf(12));

        Iterator objs = set.iterator();
        while (objs.hasNext())
            System.out.println(objs.next());
    }
}
