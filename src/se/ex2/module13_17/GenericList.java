package se.ex2.module13_17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericList {

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        data.add("Hello");
        data.add("World");

        Iterator<String> it = data.iterator();
        while (it.hasNext()) {
            String str = it.next(); // 強制轉型,不再需要
            System.out.println(str);
        }
    }

}
