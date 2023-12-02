/*
 1.Hashtable 內部是一個"類似表格"的資料結構來儲存資料, 每一筆資料都有
   對應的索引鍵(key) , 這索引鍵是物件的型態 , 但是通常為方便起見, 大
   部份的情況都是利用"字串"值當做索引鍵(key). 反之當欲取出這筆資料時,
   也是利用剛剛所設定的索引鍵值來取出資料
 
 2.欲儲存不同的資料時必需用不同的索引鍵, 否則其索引鍵所對應資料值為最
   後儲存的那筆資料
 
 3.Hashtable 的資料也是物件的型態, 所以可以儲存任何形式的資料, 使用者
   取出資料的同時, 必須注意該資料的型態而自行作物件資料轉換(casting)的動作. 
 
 */
package se.ex2.david.additional;

import java.util.*;

public class TestHashtable {
	public static void main(String args[]) {
		Hashtable hash = new Hashtable();
		hash.put("one", new Integer(1));
		hash.put("two", "2");
		hash.put("three", new Float(3.0));

		Integer oneValue = (Integer) hash.get("one");
		String twoValue = (String) hash.get("two");
		Float threeValue = (Float) hash.get("three");

		System.out.println(oneValue);
		System.out.println(twoValue);
		System.out.println(threeValue);
	}
}
