package se.ex2.module18_20;

import java.util.*;

public class TestTreeSet {
	public static void main(String args[]) {
		Set set = new TreeSet();
		set.add(new Integer(56));
		set.add(new Integer(34));
		set.add(new Integer(12));

		Iterator objs = set.iterator();
		while (objs.hasNext())
			System.out.println(objs.next());
	}
}
