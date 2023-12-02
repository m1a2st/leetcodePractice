package se.ex2.module18_20;

import java.util.*;

public class TestQueue {
	public static void main(String[] args) {
		Queue q = new LinkedList();
		q.offer("First");
		q.offer("Second");
		q.offer("Third");
		Object o;
		System.out.println(q.toString());
		while ((o = q.poll()) != null) {
			String s = (String) o;
			System.out.println(s);
		}
		System.out.println(q.toString());
	}
}
