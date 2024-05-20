/**
 * 1.Hashtable 內部是一個"類似表格"的資料結構來儲存資料, 每一筆資料都有
 * 對應的索引鍵(key) , 這索引鍵是物件的型態 , 但是通常為方便起見, 大
 * 部份的情況都是利用"字串"值當做索引鍵(key). 反之當欲取出這筆資料時,
 * 也是利用剛剛所設定的索引鍵值來取出資料
 * <p>
 * 2.欲儲存不同的資料時必需用不同的索引鍵, 否則其索引鍵所對應資料值為最
 * 後儲存的那筆資料
 * <p>
 * 3.Hashtable 的資料也是物件的型態, 所以可以儲存任何形式的資料, 使用者
 * 取出資料的同時, 必須注意該資料的型態而自行作物件資料轉換(casting)的動作.
 */

package se.ex2.david.additional;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TestHashtable_Enumeration {
    public static void main(String[] args) {
        Hashtable map = new Hashtable();
        map.put("one", Integer.valueOf(1));
        map.put("two", "2");
        map.put("three", new Float(3.0));

        Integer oneValue = (Integer) map.get("one");
        String twoValue = (String) map.get("two");
        Float threeValue = (Float) map.get("three");

        System.out.println(oneValue);
        System.out.println(twoValue);
        System.out.println(threeValue);

        // 應測試改用keySet()的作法看看
        // 取出所有的key(keyset),包裝為Set的型態
        /**
         * keySet() 方法來自Map介面, 所以所有Map家族成員都適用此方式取值 , 因此Hashtable類別也當然適用
         */
        System.out.println();
        Set keyset = map.keySet(); // 取出所有的key(keyset),包裝為Set的型態

        Iterator keys = keyset.iterator();
        while (keys.hasNext())
            System.out.println(map.get(keys.next()));

        // 應測試改用values()的作法看看
        // 取出所有的value,包裝為Collection的型態
        /**
         * values() 方法來自Map介面, 所以所有Map家族成員都適用此方式取值 , 因此Hashtable類別也當然適用
         */
        System.out.println();
        Collection c = map.values();// 取出所有的value,包裝為Collection的型態

        Iterator values = c.iterator(); // 再利用Iterator介面取值
        while (values.hasNext())
            System.out.println(values.next());

        System.out.println(); // 或再利用JDK 1.5 的for-each取值
        for (Object value : c)
            System.out.println(value);

        // JDK 1.0其它方法取值 -> elements()
        // 只有 Hashtable 才有此method, 故呼叫此method時不能用多型的寫法
        System.out.println();
        Enumeration vals = map.elements();
        while (vals.hasMoreElements())
            System.out.println(vals.nextElement());

        //取出所有的key -> keys()
        //只有 Hashtable 才有此method, 故呼叫此method時不能用多型的寫法
        System.out.println();
        System.out.println("所有的keys如下:");
        Enumeration ekeys = map.keys();
        while (ekeys.hasMoreElements()) {
            System.out.println(ekeys.nextElement());
        }

    }
}
