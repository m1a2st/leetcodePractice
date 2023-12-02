package se.ex2.module13_17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeforeGenericList {

	public static void main(String[] args) {
		List data = new ArrayList();
		data.add("Hello");
		data.add("World");

		Iterator it = data.iterator();
		while (it.hasNext()) {
			String str = (String) it.next(); // 強制轉型
			System.out.println(str);
		}
	}

}
