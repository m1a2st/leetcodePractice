package se.ex2.module13_17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnhanceForCollection {

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
//		Set<String> data = new HashSet<String>();
        data.add("Hello");
        data.add("World");

        System.out.println("傳統的for 迴圈");
        for (int i = 0; i < data.size(); i++)
            System.out.println(data.get(i)); // (注意:Set不能用傳統的for迴圈)
        System.out.println();

        System.out.println("使用iterator迴圈");
        for (Iterator it = data.iterator(); it.hasNext(); )
            System.out.println(it.next() + " ");
        System.out.println();

        System.out.println("增強功能的 for 迴圈(Using Enhanced foreach)");
        for (String str : data)
            System.out.println(str);
        System.out.println();

    }

}
