package se.ex2.module13_17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("one", Integer.valueOf(1));
        map.put("two", "2");
        map.put("three", new Float(3.0));
//		map.put("three","hello");//新的value，會覆蓋掉舊的值

        System.out.println(map.get("one"));
        System.out.println(map.get("two"));
        System.out.println(map.get("three"));


        // 取出所有的key,包裝為Set的型態
        Set set = map.keySet();

        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object myKey = it.next();
            System.out.println(myKey + "=" + map.get(myKey));
        }

        //keySet() 方法來自Map介面, 所以所有Map家族成員都適用此方式取值

    }

}
