package parctice.se.ex2.module13_17;

import java.util.ArrayList;
import java.util.List;

public class EnhanceForAttention {

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        data.add("David1");
        data.add("David2");
        data.add("David3");

        for (int i = data.size() - 1; i >= 0; i--)
            System.out.println(i + ": " + data.get(i));
        System.out.println();

        for (String str : data)
            // ※以上我做不到
            System.out.println(str); // ※傳統for迴圈, 薑老的辣
    }

}
