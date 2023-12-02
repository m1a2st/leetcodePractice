package se.ex2.module13_17;

import java.util.HashMap;
import java.util.Map;

public class GenericMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 3; i++) {
			map.put(new Integer(i), "number" + i);
		}
		System.out.println(map.get(new Integer(0)));
		System.out.println(map.get(new Integer(1)));
		System.out.println(map.get(new Integer(2)));
	}

}
