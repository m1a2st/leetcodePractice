package main.java.parctice.se.ex2.module13_17;

import java.util.HashMap;
import java.util.Map;

public class GenericMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 3; i++) {
            map.put(Integer.valueOf(i), "number" + i);
        }
        System.out.println(map.get(Integer.valueOf(0)));
        System.out.println(map.get(Integer.valueOf(1)));
        System.out.println(map.get(Integer.valueOf(2)));
    }

}
