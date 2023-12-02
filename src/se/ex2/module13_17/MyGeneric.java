package se.ex2.module13_17;

import java.util.*;

class MyGenericType<Type> {

	private List<Type> list;

	public MyGenericType() {
		list = new Vector<Type>();
	}

	public void add(Type t) {
		list.add(t);
	}

	public Type get(int i) {
		return list.get(i);
	}
}

public class MyGeneric {
	public static void main(String[] args) {
		MyGenericType<String> myGeneric = new MyGenericType<String>();
		for (int i = 0; i < 3; i++) {
			myGeneric.add("number" + i);
			System.out.println(myGeneric.get(i));
		}
	}
}
