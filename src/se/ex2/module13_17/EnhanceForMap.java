package se.ex2.module13_17;

import java.util.HashMap;
import java.util.Map;

public class EnhanceForMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 0; i < 6; i++) {
			map.put(i, "David" + i);
		}
		for (String val : map.values()) {
			System.out.println(val);
		}
	}

}
