package practice.leetcode.data_structure.commomAlogrithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Greedy {
    public static void main(String[] args) {
        //創建電台
        Map<String, Set<String>> broadcast = new HashMap<>();
        //將電台放入
        Set<String> location = new HashSet<>();
        location.add("北京");
        location.add("上海");
        location.add("天津");
        Set<String> location2 = new HashSet<>();
        location2.add("北京");
        location2.add("廣州");
        location2.add("深圳");
        Set<String> location3 = new HashSet<>();
        location3.add("成都");
        location3.add("上海");
        location3.add("杭州");
        Set<String> location4 = new HashSet<>();
        location4.add("上海");
        location4.add("天津");
        Set<String> location5 = new HashSet<>();
        location5.add("杭州");
        location5.add("大連");
        broadcast.put("k1", location);
        broadcast.put("k2", location2);
        broadcast.put("k3", location3);
        broadcast.put("k4", location4);
        broadcast.put("k5", location5);
        Set<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("廣州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大連");
        List<String> selectedBroadcast = new ArrayList<>();
        //定義一個臨時集合，保存遍歷過程中，電台覆蓋的地區和當前還沒有覆蓋地區的交集
        Set<String> temp = new HashSet<>();
        //定義一個maxKey，保存再一次遍歷過程中，能夠覆蓋最大為覆蓋的地區對應的電台的key
        String maxKey = null;
        //如果maxKey != null ，則會加入selectedBroadcast
        while (allAreas.size() != 0) { //如果allAreas不為0，則表示還沒有覆蓋到所有地區
            maxKey = null;
            //遍歷broadcast，取出對應的Key
            for (String key : broadcast.keySet()) {
                temp.clear();
                //當前的key能覆蓋的地區
                Set<String> areas = broadcast.get(key);
                temp.addAll(areas);
                //取出temp跟allAreas的交集，交集會賦予給temp
                temp.retainAll(allAreas);
                //如果當前這個集合包含的為覆蓋地區，比maxKey指向的地區集合還多
                //就需要重置maxKey
                if (temp.size() > 0 && (maxKey == null || temp.size() > broadcast.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey != null，就應該將maxKey加入selectedBroadcast
            if (maxKey != null) {
                selectedBroadcast.add(maxKey);
                //將maxKey指向的電台覆蓋的地區，從allAreas去掉
                allAreas.removeAll(broadcast.get(maxKey));
            }

        }
        System.out.println(selectedBroadcast);
    }

}
